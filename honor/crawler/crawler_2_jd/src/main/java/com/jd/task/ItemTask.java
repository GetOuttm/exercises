package com.jd.task;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jd.entity.Item;
import com.jd.service.ItemService;
import com.jd.utils.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 商品定时任务
 */
@Component//创建实例
public class ItemTask {

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private ItemService itemService;
    //解析json工具类
    private static final ObjectMapper MAPPER = new ObjectMapper();

    //当下载任务完成后，间隔多长时间进行下一次任务
    @Scheduled(fixedDelay = 1000*1000) //100秒
    public void itemTask() throws Exception {
        //声明需要解析得初始地址
        String url = "https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&wq=%E6%89%8B%E6%9C%BA&s=51&click=0&page=";

        //按照页面对搜索结果进行遍历
        for (int i = 1; i < 10; i=i+2) {
            String html = this.httpUtils.doGetHtml(url + i);
            System.out.println(html);

            //解析页面获取商品数据并存储
            if (html != null) {
                this.parse(html);
            }
        }

        System.out.println("手机数据抓取完成");
    }
    //解析页面获取商品数据并存储
    private void parse(String html) throws Exception {
        //解析html获取Document
        Document document = Jsoup.parse(html);

        //获取spu信息

        Elements spuElms = document.select("div#J_goodsList > ul >li");

        for (Element spuElm : spuElms) {
            //获取spu
            String attr = spuElm.attr("data-spu");
            long spu = Long.parseLong("".equals(attr)?"0":attr);
            //获取sku信息
            Elements skuElms = spuElm.select("li.ps-item");
            for (Element skuElm : skuElms) {
                long sku = Long.parseLong(skuElm.select("[data-sku]").attr("data-sku"));

                //根据sku查询商品数据
                Item item = new Item();
                item.setSku(sku);
                List<Item> items = this.itemService.findAll(item);

                if (items.size() > 0) {
                    //商品存在进行下一次循环，商品不保存
                    continue;
                }

                //设置商品spu
                item.setSpu(spu);
                //获取商品得详情
                String itemUrl = "https://item.jd.com/" + sku + ".html";
                item.setUrl(itemUrl);

                //商品图片
                //http://img13.360buyimg.com/n1/jfs/t1/92813/35/93/213545/5da6d46dE044b6502/9146c06cb23323ef.jpg
                String picUrl = /*"https:" + */skuElm.select("img[data-sku]").first().attr("data-lazy-img");
                //	图片路径可能会为空的情况
                if(!StringUtils.isNotBlank(picUrl)){
                    picUrl =skuElm.select("img[data-sku]").first().attr("data-lazy-img-slave");
                }
                //小图片换成大图片
                picUrl = "https:" + picUrl.replace("/n7/","/n1/");
                //下载图片
                String picName = this.httpUtils.doGetImage(picUrl);
                item.setPic(picName);

                //商品价格
                String priceJson = this.httpUtils.doGetHtml("https://p.3.cn/prices/mgets?skuIds=J_" + sku);
                //解析
                double price = MAPPER.readTree(priceJson).get(0).get("p").asDouble();
                item.setPrice(price);


                //商品标题
                String itemInfo = this.httpUtils.doGetHtml(item.getUrl());
                String title = Jsoup.parse(itemInfo).select("div.sku-name").text();
                item.setTitle(title);

                //时间
                item.setCreated(new Date());//创建时间
                item.setUpdated(item.getCreated());//更新时间
                System.out.println(item);

                //保存商品数据到数据库
                this.itemService.save(item);
            }
        }
    }
}

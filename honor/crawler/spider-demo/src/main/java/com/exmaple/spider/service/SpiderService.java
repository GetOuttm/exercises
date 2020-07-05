package com.exmaple.spider.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.exmaple.spider.common.HttpClientUtils;
import com.exmaple.spider.constant.SysConstant;
import com.exmaple.spider.dao.GoodsInfoDao;
import com.exmaple.spider.entity.GoodsInfo;
import com.google.common.collect.Lists;

@Service
public class SpiderService {
    private static Logger logger = LoggerFactory.getLogger(SpiderService.class);
    @Autowired
    private GoodsInfoDao goodsInfoDao;
    private static String HTTPS_PROTOCOL = "https:";

    public void spiderData(String url, Map<String, String> params) {
        String html = HttpClientUtils.sendGet(url, null, params);
        if(!StringUtils.isBlank(html)) {
            List<GoodsInfo> goodsInfos =parseHtml(html);
            goodsInfoDao.saveBatch(goodsInfos);
        }
    }
    /**
     * 解析html
     * @param html
     */
    private List<GoodsInfo> parseHtml(String html) {
        //商品集合
        List<GoodsInfo> goods = Lists.newArrayList();
        /**
         * 获取dom并解析
         */
        Document document = Jsoup.parse(html);
        Elements elements = document.
                select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
        int index = 0;
        for(Element element : elements) {
            String goodsId = element.attr("data-sku");
            String goodsName = element.select("div[class=p-name p-name-type-2]").select("em").text();
            String goodsPrice = element.select("div[class=p-price]").select("strong").select("i").text();
            String imgUrl = HTTPS_PROTOCOL + element.select("div[class=p-img]").select("a").select("img").attr("src");
            GoodsInfo goodsInfo = new GoodsInfo(goodsId, goodsName, imgUrl, goodsPrice);
            goods.add(goodsInfo);
            String jsonStr = JSON.toJSONString(goodsInfo);
            logger.info("成功爬取【" + goodsName + "】的基本信息 ");
            logger.info(jsonStr);
            if(index ++ == 9) {
                break;
            }
        }
        return goods;
    }
    /**
     * Service层通过使用HttpClientUtils模拟浏览器访问页面，然后再使用Jsoup对页面进行解析，Jsoup的使用和Jquery的DOM结点选取基本相似，可以看作是java版的Jquery，如果写过Jquery的人基本上就可以看出是什么意思。
     * 每抓取一条信息就会打印一次记录，而且使用fastjson将对象转换成json字符串并输出
     * 在写测试代码的时候发现，发现爬取的数据只有前10条是完整的，后面的爬取的有些是不完整的，按道理来说是对于整个页面都是通用的，就是不知道为什么只有前面才是完整的，排查了很久没用发现原因，这里就只选择了前面的10条作为要爬取的数据
     * 我们了解到，我们要爬取数据前要分析我们要爬取的数据有哪些，再分析网友的结构，然后对网页进行解析，选取对应的DOM或者使用正则表达式筛选，思路首先要清晰，有了思路之后剩下的也只是把你的思路翻译成代码而已了。
     */
}

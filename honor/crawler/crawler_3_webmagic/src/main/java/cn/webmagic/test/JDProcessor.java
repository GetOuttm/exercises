package cn.webmagic.test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class JDProcessor implements PageProcessor {
    /**
     * 负责解析 页面
     * @param page page
     */
    @Override
    public void process(Page page) {
        //解析返回得数据page，并且把解析得结果放到ResultItems中
        //css选择器
        page.putField("div",page.getHtml().css("li.fore2 >div").all());

        //XPath   可以学习xpath的方法
        page.putField("div2",page.getHtml().xpath("//div[@id=J_service]/div/ul/li/a/span"));

        //正则表达式
        page.putField("div3",page.getHtml().css("div.logo > h2").all());
        page.putField("div4",page.getHtml().css("ul.fr a").regex(".*京东.*").all());

        //处理结果的API   get  toString 都是返回第一条   all返回所有
        page.putField("div5",page.getHtml().css("ul.fr a").regex(".*京东.*").get());
        page.putField("div6",page.getHtml().css("ul.fr a").regex(".*京东.*").toString());

        //获取链接
        page.addTargetRequests(page.getHtml().css("div.mod_container").links().regex("https://www.jd.com/.\\W+?.*").all());
        page.putField("urls",page.getHtml().css("div.mod_container a").all());
    }

    private Site site = Site.me()
            .setCharset("utf8")//设置编码
            .setTimeOut(10000)//设置超时时间  单位毫秒
            .setRetrySleepTime(3000)//设置重试的间隔时间  单位毫秒
            .setSleepTime(3)//设置重试次数
            ;

    @Override
    public Site getSite() {
        return site;
    }
    //主函数执行爬虫
    public static void main(String[] args) {
        //设置爬取数据得页面
        Spider.create(new JDProcessor())
                .addUrl("https://www.jd.com/")//设置爬取数据的页面
                .addPipeline(new FilePipeline("D:\\桌面\\面试\\a"))//输出
                .thread(5)//设置多线程
                .run();//执行爬虫
    }
}

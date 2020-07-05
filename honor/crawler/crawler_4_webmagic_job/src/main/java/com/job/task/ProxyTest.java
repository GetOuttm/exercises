package com.job.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

/**
 * 代理测试
 */
@Component
public class ProxyTest implements PageProcessor {

    @Scheduled(fixedDelay = 1000)
    public void Process() {
        //创建一个下载器Downloader
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();

        //给下载器设置代理服务器信息   ip + 端口
        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(new Proxy("58.220.95.79",10000)));

        Spider.create(new ProxyTest())
                .addUrl("https://httpbin.org/ip")//这个网址可以获取请求ip
                .setDownloader(httpClientDownloader)//设置代理器
                .run();
    }

    @Override
    public void process(Page page) {
        System.out.println(page.getHtml().toString());
    }

    private Site site = Site.me();

    @Override
    public Site getSite() {
        return site;
    }
}

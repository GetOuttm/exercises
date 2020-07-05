package com.job.task;

import com.job.entity.JobInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

@Component
public class JobProcessor implements PageProcessor {

    private String url = "https://search.51job.com/list/010000,000000,0000,01%252C32,9,99,java,2,1.html?lang=c&stype=&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&providesalary=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
    @Override
    public void process(Page page) {
        //解析页面，获取招聘信息详情的url地址
        List<Selectable> nodes = page.getHtml().css("div#resultList div.el").nodes();
        //判断获取到的集合是否为空
        if (nodes.size() == 0) {
            // 如果为空那就是招聘详情页
            //解析页面，保存数据
            this.saveJObInfo(page);

        } else {
            //如果不为空，表示这是列表页。解析出详情页的url地址，放到队列中
            for (Selectable node : nodes) {
                //获取url地址
                String jobInfoUrl = node.links().toString();
                //把获取到的url地址放到任务队列中
                page.addTargetRequest(jobInfoUrl);

            }

            //获取下一页的url
            String bkUrl = page.getHtml().css("div.p_in li.bk").nodes().get(1).links().toString();
            //把url放到队列中
            page.addTargetRequest(bkUrl);
        }

        String s = page.getHtml().toString();
    }

    //解析页面获取招聘详细信息，保存数据
    private void saveJObInfo(Page page) {
        //创建招聘详情对象
        JobInfo jobInfo = new JobInfo();

        //解析页面
        Html html = page.getHtml();

        //获取数据，封装到对象中
        String time = Jsoup.parse(html.css("div.cn p.msg").regex(".*发布").toString()).text();
        jobInfo.setTime(time);
        jobInfo.setUrl(page.getUrl().toString());
        jobInfo.setCompanyName(html.css("div.cn p.cname a","text").toString());
        jobInfo.setCompanyAddr(Jsoup.parse(html.css("div.bmsg").nodes().get(1).toString()).text());
        jobInfo.setCompanyInfo(Jsoup.parse(html.css("div.tmsg").toString()).text());
        jobInfo.setJobName(html.css("div.cn h1","text").toString());
        //该地址是在一个p标签内。由多个字符串组成
        jobInfo.setJobAddr(html.css("div.cn p.msg", "text").toString());
        jobInfo.setJobInfo(Jsoup.parse(html.css("div.job_msg").toString()).text());

        //获取薪资
        Integer[] salary = MathSalary.getSalary(html.css("div.cn strong", "text").toString());
        jobInfo.setSalaryMin(salary[0]);
        jobInfo.setSalaryMax(salary[1]);

        //把结果保存
        page.putField("jobInfo",jobInfo);

    }
    private Site site = Site.me()
            .setCharset("gbk")//设置编码
            .setTimeOut(100*1000)//设置超时时间
            .setRetrySleepTime(3000)//设置重试时间
            .setRetryTimes(3);//设置重试次数

    @Override
    public Site getSite() {
        return site;
    }


    @Autowired
    private SpringDataPipeLine springDataPipeLine;

    /**
     * initialDelay:当任务启动后，等多久执行方法
     * fixedDelay：每隔多久执行一次
     */
//    @Scheduled(initialDelay = 1000,fixedDelay = 100*1000)
    public void processor() {
        Spider.create(new JobProcessor())
                .addUrl(url)//初始化地址
                //设置布隆去重过滤器，指定最多对1000000数据进行去重操作
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
                .thread(10)//设置线程
                .addPipeline(this.springDataPipeLine)
                .run();
    }
}

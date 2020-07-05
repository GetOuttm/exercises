package com.exmaple.spider.handler;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exmaple.spider.constant.SysConstant;
import com.exmaple.spider.service.SpiderService;
import com.google.common.collect.Maps;
/**
 * 爬虫调度处理器
 * @author ZGJ
 * @date 2017年7月15日
 */
@Component
public class SpiderHandler {
    @Autowired
    private SpiderService spiderService;

    private static final Logger logger = LoggerFactory.getLogger(SpiderHandler.class);

    public void spiderData() {
        logger.info("爬虫开始....");
        Date startDate = new Date();
        // 使用现线程池提交任务
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //引入countDownLatch进行线程同步，使主线程等待线程池的所有任务结束，便于计时
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for(int i = 1; i < 201; i += 2) {
            Map<String, String> params = Maps.newHashMap();
            params.put("keyword", "零食");
            params.put("enc", "utf-8");
            params.put("wc", "零食");
            params.put("page", i + "");
            executorService.submit(() -> {
                spiderService.spiderData(SysConstant.BASE_URL, params);
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        Date endDate = new Date();

        FastDateFormat fdf = FastDateFormat.getInstance(SysConstant.DEFAULT_DATE_FORMAT);
        logger.info("爬虫结束....");
        logger.info("[开始时间:" + fdf.format(startDate) + ",结束时间:" + fdf.format(endDate) + ",耗时:"
                + (endDate.getTime() - startDate.getTime()) + "ms]");


        /**
         * SpiderHandelr作为一个爬虫服务调度处理器，这里采用了ExecutorService线程池创建了5个线程进行多线程爬取，我们通过翻页发现，翻页过后地址URL多了一个page参数，而且这个参数还只能是奇数才有效，也就是page为1,3，5,7……代表第1,2,3,4……页。这里就只爬了100页，每页10条数据，将page作为不同的参数传给不同的任务。
         * 这里我想统计一下整个爬取任务所用的时间，假如不使用同步工具类的话，因为任务是分到线程池中去运行的，而主线程会继续执行下去，主线程和线程池中的线程是独立运行的，主线程会提前结束，所以就无法统计时间。
         * 这里我们使用CountDownLatch同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行。也就是说可以让主线程等待线程池内的线程执行结束再继续执行，里面维护了一个计数器，开始的时候构造计数器的初始数量，每个线程执行结束的时候调用countdown()方法，计数器就减1，调用await()方法，假如计数器不为0就会阻塞，假如计数器为0了就可以继续往下执行
         * executorService.submit(() -> {
         *     spiderService.spiderData(SysConstant.BASE_URL, params);
         *     countDownLatch.countDown();
         * });
         *
         * 这里使用了Java8中的lambda表达式替代了匿名内部类，详细的可以自行去了解
         * 这里还可以根据自己的业务需求做一些代码的调整和优化，比如实现定时任务爬取等等
         *
         */

    }
}
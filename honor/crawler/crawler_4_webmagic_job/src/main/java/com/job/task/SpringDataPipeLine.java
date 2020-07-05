package com.job.task;

import com.job.entity.JobInfo;
import com.job.service.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class SpringDataPipeLine implements Pipeline {

    @Autowired
    private JobInfoService jobInfoService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        //获取封装好的详情对象
        JobInfo jobInfo = resultItems.get("jobInfo");
        //判断是否为空
        if (jobInfo != null) {
            //不为空保存到数据库
            this.jobInfoService.save(jobInfo);
        }
    }
}

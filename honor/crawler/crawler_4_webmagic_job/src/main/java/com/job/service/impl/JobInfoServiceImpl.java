package com.job.service.impl;

import com.job.dao.JobInfoDao;
import com.job.entity.JobInfo;
import com.job.service.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobInfoServiceImpl implements JobInfoService {

    @Autowired
    private JobInfoDao jobInfoDao;

    @Override
    @Transactional//开启事务
    public void save(JobInfo jobInfo) {
        //查询原有数据     招聘信息的时间和url
        JobInfo param = new JobInfo();
        param.setUrl(jobInfo.getUrl());
        param.setTime(jobInfo.getTime());
        List<JobInfo> list = this.findJobInfo(param);

        //是否为空
        if (list.size() == 0) {
            //表示招聘信息不存在，或者已经跟新，需要新增或更新数据库
            this.jobInfoDao.saveAndFlush(jobInfo);//新增或者刷新

        }
    }

    @Override
    public List<JobInfo> findJobInfo(JobInfo jobInfo) {
        //设置查询条件
        Example example = Example.of(jobInfo);

        List list = this.jobInfoDao.findAll(example);

        return list;
    }
}

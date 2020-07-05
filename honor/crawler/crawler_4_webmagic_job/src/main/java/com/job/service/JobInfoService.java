package com.job.service;

import com.job.entity.JobInfo;

import java.util.List;

public interface JobInfoService {
    /**
     * 保存前程无忧工作信息
     * @param jobInfo
     */
    void save(JobInfo jobInfo);

    /**
     * 根据条件查询工作信息
     * @param jobInfo
     * @return
     */
    List<JobInfo> findJobInfo(JobInfo jobInfo);
}

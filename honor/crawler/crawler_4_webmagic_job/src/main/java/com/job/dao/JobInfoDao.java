package com.job.dao;

import com.job.entity.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobInfoDao extends JpaRepository<JobInfo,Long> {
}

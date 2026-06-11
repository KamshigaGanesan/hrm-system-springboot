package com.hrm.hrm.services;

import com.hrm.hrm.dtos.requestdtos.JobRequest;
import com.hrm.hrm.dtos.responsedtos.JobResponse;

import java.util.List;

public interface JobService {

    void createJob(JobRequest jobRequest);
    void updateJob(JobRequest jobRequest);
    boolean checkJobExists(Long id);
    void deleteJob(Long id);
    JobResponse getJob(Long id);
    List<JobResponse> getJobs();
}

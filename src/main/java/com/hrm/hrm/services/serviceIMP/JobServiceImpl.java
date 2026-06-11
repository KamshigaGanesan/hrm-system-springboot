package com.hrm.hrm.services.serviceIMP;

import com.hrm.hrm.dtos.requestdtos.JobRequest;
import com.hrm.hrm.dtos.responsedtos.JobResponse;
import com.hrm.hrm.entities.Job;
import com.hrm.hrm.repositories.JobRepository;
import com.hrm.hrm.services.JobService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;

    public void createJob(JobRequest jobRequest){
        Job job=new Job();
        job.setDescription(jobRequest.getDescription());
        job.setId(jobRequest.getId());
        job.setName(jobRequest.getName());
        jobRepository.save(job);
    }

    @Transactional
    public void updateJob(JobRequest jobRequest) {
        Job job =jobRepository.findById(jobRequest.getId()).orElse(null);
        BeanUtils.copyProperties(jobRequest, job);
        jobRepository.save(job);
    }

    @Override
    public boolean checkJobExists(Long id) {
        return jobRepository.existsById(id);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    @Override
    public JobResponse getJob(Long id) {
        JobResponse jobResponse=new JobResponse();
        Job job=jobRepository.findById(id).orElse(null);
//        jobResponse.setId(job.getId());
//        jobResponse.setName(job.getName());
//        jobResponse.setDescription(job.getDescription());
        BeanUtils.copyProperties(job,jobResponse);
        return jobResponse;
    }

    @Override
    public List<JobResponse> getJobs(){
        List<JobResponse> jobResponseList=new ArrayList<>();
        List<Job> jobList=jobRepository.findAll();
        for(Job job :jobList){
            JobResponse jobResponse=new JobResponse();
            BeanUtils.copyProperties(job,jobResponse);
            jobResponseList.add(jobResponse);
        }
        return jobResponseList;
    }
}

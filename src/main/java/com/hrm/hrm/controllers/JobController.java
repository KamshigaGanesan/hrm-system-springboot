package com.hrm.hrm.controllers;

import com.hrm.hrm.dtos.requestdtos.JobRequest;
import com.hrm.hrm.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")

@CrossOrigin

public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping(value = "/job-title")
    public ResponseEntity<Object> createJob(@RequestBody JobRequest jobRequest){
        jobService.createJob(jobRequest);
        return ResponseEntity.ok("Job Created Successfully");

    }

    @PutMapping(value="/job-title")
    public ResponseEntity<Object> updateJob(@RequestBody JobRequest jobRequest){
        if(!jobService.checkJobExists(jobRequest.getId())){
            return ResponseEntity.ok("Job Not Found");
        }
        jobService.updateJob(jobRequest);
        return ResponseEntity.ok("Job Updated Successfully");
    }

    @DeleteMapping(value="/job-title/{id}")
    public ResponseEntity<Object> deleteJob(@PathVariable Long id){
        if(!jobService.checkJobExists(id)){
            return ResponseEntity.ok("Job Not Found");
        }
        jobService.deleteJob(id);
        return ResponseEntity.ok("Job Deleted Successfully");
    }

    @GetMapping(value="/job-title/{id}")
    public ResponseEntity<Object> getJob(@PathVariable Long id){
        if(!jobService.checkJobExists(id)){
            return ResponseEntity.ok("Job Not Found");
        }
        return ResponseEntity.ok(jobService.getJob(id));
    }

    @GetMapping(value="/job-title")
    public ResponseEntity<Object> getJobs(){
        return ResponseEntity.ok(jobService.getJobs());
    }
}

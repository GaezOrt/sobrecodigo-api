package com.example.medial.jobs.business;

import com.example.medial.jobs.models.Job;
import com.example.medial.jobs.repositories.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsBusiness {

    @Autowired
    private JobsRepository jobsRepository;


    public List<Job> getRecentJobs(){
        List<Job> jobs= jobsRepository.findAll();

        return jobs;
    }
}

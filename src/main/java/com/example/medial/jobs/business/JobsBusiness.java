package com.example.medial.jobs.business;

import com.example.medial.jobs.dtos.JobDto;
import com.example.medial.jobs.models.Job;
import com.example.medial.jobs.repositories.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobsBusiness {

    @Autowired
    private JobsRepository jobsRepository;


    public List<JobDto> getRecentJobs(){

        List<Job> jobs= jobsRepository.findAll();
        List<JobDto> jobDtos = new ArrayList<>();
        for(Job job: jobs){
            JobDto jobDto = new JobDto();
            jobDto.setId(job.getId());
            jobDto.setDescription(job.getDescription());
            jobDto.setName(job.getName());
            jobDtos.add(jobDto);

        }
        return jobDtos;

    }
}

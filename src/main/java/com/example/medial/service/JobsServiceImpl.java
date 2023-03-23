package com.example.medial.service;

import com.example.medial.model.dto.JobDto;
import com.example.medial.model.dto.JobPositionDto;
import com.example.medial.model.entity.Currency;
import com.example.medial.model.entity.Job;
import com.example.medial.model.entity.JobPosition;
import com.example.medial.repository.CurrenciesRepository;
import com.example.medial.repository.JobsPositionRepository;
import com.example.medial.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobsServiceImpl {

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private CurrenciesRepository currenciesRepository;

    @Autowired
    private JobsPositionRepository jobsPositionRepository;


    public List<JobDto> getRecentJobs(){

        List<Job> jobs= jobsRepository.findAll();
        List<JobDto> jobDtos = new ArrayList<>();
        for(Job job: jobs){
            JobDto jobDto = new JobDto();
            jobDto.setId(job.getId());
            jobDto.setDescription(job.getDescription());
            jobDto.setTitle(job.getTitle());
            jobDto.setSalary(job.getSalary());
            jobDto.setSalary(job.getSalary());

            JobPositionDto jobPositionDto = new JobPositionDto();
            jobPositionDto.setPosition(job.getPosition().getPosition());
            jobPositionDto.setId(job.getPosition().getId());
            jobDto.setPosition(jobPositionDto);
            jobDtos.add(jobDto);
        }
        return jobDtos;

    }

    public Boolean insertJob(JobDto jobDto){

        Job job = new Job();

        Currency currency = currenciesRepository.findById(jobDto.getCurrency().getId()).get();
        job.setCurrency(currency);

        job.setDescription(jobDto.getDescription());

        JobPosition jobPosition = jobsPositionRepository.findById(jobDto.getPosition().getId()).get();
        job.setPosition(jobPosition);

        job.setRelocation(true);
        job.setSalary(jobDto.getSalary());
        job.setTitle(jobDto.getTitle());
        jobsRepository.save(job);
        return true;

    }

}

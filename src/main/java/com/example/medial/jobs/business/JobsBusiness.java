package com.example.medial.jobs.business;

import com.example.medial.exceptions.CurrencyNotFoundException;
import com.example.medial.exceptions.JobNotFoundException;
import com.example.medial.jobs.dtos.JobDto;
import com.example.medial.jobs.dtos.JobPositionDto;
import com.example.medial.model.entity.Currency;
import com.example.medial.model.entity.Job;
import com.example.medial.model.entity.JobPosition;
import com.example.medial.repository.CurrenciesRepository;
import com.example.medial.repository.JobsPositionRepository;
import com.example.medial.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobsBusiness {

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

            JobPositionDto jobPositionDto = new JobPositionDto();
            jobPositionDto.setPosition(job.getPosition().getPosition());
            jobPositionDto.setId(job.getPosition().getId());
            jobDto.setPosition(jobPositionDto);
            jobDtos.add(jobDto);
        }
        return jobDtos;

    }

    @Transactional
    public Boolean insertJob(JobDto jobDto){

        Job job = new Job();

        Currency currency = currenciesRepository.findById(jobDto.getCurrency().getId())
                .orElseThrow(()->new CurrencyNotFoundException("Currency with id:" + jobDto.getCurrency().getId() + " not found."));
        job.setCurrency(currency);

        job.setDescription(jobDto.getDescription());

        JobPosition jobPosition = jobsPositionRepository.findById(jobDto.getPosition().getId())
                .orElseThrow(()-> new JobNotFoundException("Job with id: " + jobDto.getPosition().getId() + " not found."));

        job.setPosition(jobPosition);
        job.setRelocation(true);
        job.setSalary(jobDto.getSalary());
        job.setTitle(jobDto.getTitle());
        //job.setModalityWork?
        jobsRepository.save(job);
        return true;

    }

}

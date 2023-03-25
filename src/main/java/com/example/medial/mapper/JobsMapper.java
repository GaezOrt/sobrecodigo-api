package com.example.medial.mapper;

import com.example.medial.exceptions.CurrencyNotFoundException;
import com.example.medial.exceptions.JobNotFoundException;
import com.example.medial.jobs.dtos.JobDto;
import com.example.medial.jobs.dtos.JobPositionDto;
import com.example.medial.model.entity.Currency;
import com.example.medial.model.entity.Job;
import com.example.medial.model.entity.JobPosition;
import com.example.medial.model.entity.ModalityWork;
import com.example.medial.repository.CurrenciesRepository;
import com.example.medial.repository.JobsPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobsMapper {

    @Autowired
    private CurrenciesRepository currenciesRepository;

    @Autowired
    private JobsPositionRepository jobsPositionRepository;
    public JobDto mapToDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setDescription(job.getDescription());
        jobDto.setTitle(job.getTitle());
        jobDto.setSalary(job.getSalary());

        JobPositionDto jobPositionDto = new JobPositionDto();
        jobPositionDto.setPosition(job.getPosition().getPosition());
        jobPositionDto.setId(job.getPosition().getId());
        jobDto.setPosition(jobPositionDto);
        return jobDto;
    }

    public Job mapDtoToJob(JobDto jobDto) {
        Currency currency = currenciesRepository.findById(jobDto.getCurrency().getId())
                .orElseThrow(()->new CurrencyNotFoundException("Currency with id:" + jobDto.getCurrency().getId() + " not found."));

        JobPosition jobPosition = jobsPositionRepository.findById(jobDto.getPosition().getId())
                .orElseThrow(()-> new JobNotFoundException("Job with id: " + jobDto.getPosition().getId() + " not found."));

        Job job = new Job();
        job.setCurrency(currency);
        job.setDescription(jobDto.getDescription());
        job.setPosition(jobPosition);
        //TODO: setRelocation
        job.setRelocation(true);
        job.setSalary(jobDto.getSalary());
        job.setTitle(jobDto.getTitle());

        ModalityWork modalityWork = new ModalityWork();
        modalityWork.setId(jobDto.getModalityJobDto().getId());
        modalityWork.setModality(jobDto.getModalityJobDto().getModality());

        job.setModalityWork(modalityWork);

        return job;
    }
}

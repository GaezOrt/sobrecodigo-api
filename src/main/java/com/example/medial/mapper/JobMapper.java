package com.example.medial.mapper;

import com.example.medial.model.dto.response.CurrencyDto;
import com.example.medial.model.dto.response.JobDto;
import com.example.medial.model.dto.response.JobPositionDto;
import com.example.medial.model.entity.Currency;
import com.example.medial.model.entity.Job;
import com.example.medial.model.entity.JobPosition;
import com.example.medial.model.entity.ModalityWork;
import org.springframework.stereotype.Component;

@Component
public class JobMapper {


    public JobDto toDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setDescription(job.getDescription());
        jobDto.setTitle(job.getTitle());

        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setCurrency(job.getCurrency().getCurrency());
        currencyDto.setId(job.getCurrency().getId());
        jobDto.setCurrency(currencyDto);

        jobDto.setSalary(job.getSalary());
        jobDto.setTecnologies(job.getTecnologies());

        JobPositionDto jobPositionDto = new JobPositionDto();
        jobPositionDto.setPosition(job.getPosition().getPosition());
        jobPositionDto.setId(job.getPosition().getId());
        jobDto.setPosition(jobPositionDto);
        return jobDto;
    }

    public Job toJob(JobDto jobDto, Currency currency, JobPosition position) {
        Job job = new Job();
        job.setDescription(jobDto.getDescription());
        job.setPosition(position);
        //TODO
        job.setRelocation(true);
        job.setSalary(jobDto.getSalary());
        job.setTitle(jobDto.getTitle());
        job.setEnterprise(jobDto.getEnterprise());
        job.setTecnologies(jobDto.getTecnologies());
        job.setCurrency(currency);

        ModalityWork modalityWork = new ModalityWork();
        modalityWork.setId(jobDto.getModalityWorkDto().getId());
        modalityWork.setModality(jobDto.getModalityWorkDto().getModality());
        job.setModalityWork(modalityWork);

        return job;
    }
}

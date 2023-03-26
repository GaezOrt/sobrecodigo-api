package com.example.medial.model.mapper;

import com.example.medial.model.dto.response.CurrencyDto;
import com.example.medial.model.dto.response.JobDto;
import com.example.medial.model.dto.response.JobPositionDto;
import com.example.medial.model.entity.Currency;
import com.example.medial.model.entity.Job;
import com.example.medial.model.entity.JobPosition;
import com.example.medial.model.entity.ModalityWork;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class JobMapper {

    private final PrettyTime prettyTime = new PrettyTime();
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

        //ChatGPT dijo que agregue esto
       // jobDto.setCreatedAt(prettyTime.format(Date.from(job.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant())));

        return jobDto;
    }

    //el createdAt se hace en el service.
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

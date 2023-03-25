package com.example.medial.service;

import com.example.medial.exceptions.CurrencyNotFoundException;
import com.example.medial.exceptions.JobNotFoundException;
import com.example.medial.mapper.JobMapper;
import com.example.medial.model.dto.response.CurrencyDto;
import com.example.medial.model.dto.response.JobDto;
import com.example.medial.model.dto.response.JobPositionDto;
import com.example.medial.model.entity.Currency;
import com.example.medial.model.entity.Job;
import com.example.medial.model.entity.JobPosition;
import com.example.medial.repository.CurrenciesRepository;
import com.example.medial.repository.JobsPositionRepository;
import com.example.medial.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class JobsServiceImpl {

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private CurrenciesRepository currenciesRepository;

    @Autowired
    private JobsPositionRepository jobsPositionRepository;

    @Autowired
    private JobMapper jobMapper;


    //Devuelve una pagina "page", de "size" elementos, ordenados de manera ascendiente/descendiente dada por "direction",
    //y el orden es dado por "sortBy"
    public List<JobDto> getRecentJobs(int page, int size, String sortBy, String direction){

        List<Job> jobs= jobsRepository.findAll();
        List<JobDto> jobDtos = new ArrayList<>();

        //para saber si el orden es ascendiente/descendiente
        Sort sort = direction.equalsIgnoreCase("ASC") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        //Info para retirar la pagina, que numero de pagina, su tamanio y el orden
        Pageable pagingSort = PageRequest.of(page, size, sort);
        Page<Job> jobsPage = jobsRepository.findAll(pagingSort);

        //si hay al menos 1 job en esa pagina, lo convierte a dto, y lo agrega a la lista para devolver
        if (jobsPage.hasContent()) {
            return jobsPage.getContent()
                    .stream()
                    .map(job -> jobMapper.toDto(job))
                    .collect(toList());
        } else {
            //si no hay ningun job dado por esa pagina, devuelve un array vacio
            return new ArrayList<>();
        }
    }

    @Transactional
    public Boolean insertJob(JobDto jobDto){

        Currency currency = currenciesRepository.findById(jobDto.getCurrency().getId())
                .orElseThrow(()->new CurrencyNotFoundException("Currency with id:" + jobDto.getCurrency().getId() + " not found."));

        JobPosition jobPosition = jobsPositionRepository.findById(jobDto.getPosition().getId())
                .orElseThrow(()-> new JobNotFoundException("Job with id: " + jobDto.getPosition().getId() + " not found."));

        Job job = jobMapper.toJob(jobDto, currency, jobPosition);
        job.setCreatedAt(LocalDateTime.now());
        jobsRepository.save(job);
        return true;
    }

}

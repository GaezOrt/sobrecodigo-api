package com.example.medial.jobs.business;

import com.example.medial.jobs.repositories.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsBusiness {

    @Autowired
    private JobsRepository projectsRepository;

}

package com.example.medial.controller;

import com.example.medial.model.enums.Api;
import com.example.medial.jobs.business.JobsBusiness;
import com.example.medial.jobs.dtos.JobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("jobsController")
@RequestMapping("/1.0/jobs")
@CrossOrigin(origins = Api.API)
@Controller
public class JobsController
{

    @Autowired
    private JobsBusiness jobsBusiness;

    //Get recent jobs
    //la url se veria como: server:port/api/1.0/jobs/recent?page=0&limit=4&sortBy=date&direction=ASC
    @GetMapping("/jobs/recent")
    public @ResponseBody
    List<JobDto> getRecentJobs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int limit,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "DESC") String direction
    ) {

        return jobsBusiness.getRecentJobs(page, limit, sortBy, direction);
    }

    //Get recent jobs
    @PostMapping("/jobs/new")
    public @ResponseBody
    Boolean getJobs(@RequestBody JobDto jobDto) {

        return jobsBusiness.insertJob(jobDto);
    }

}

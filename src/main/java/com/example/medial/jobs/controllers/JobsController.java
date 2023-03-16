package com.example.medial.jobs.controllers;

import com.example.medial.enums.Api;
import com.example.medial.jobs.business.JobsBusiness;
import com.example.medial.jobs.dtos.JobDto;
import com.example.medial.jobs.models.Job;
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
    @RequestMapping(value = "/new-jobs", method = RequestMethod.GET)
    public @ResponseBody
    List<JobDto> getJobs() {

        return jobsBusiness.getRecentJobs();
    }

    //Get recent jobs
    @RequestMapping(value = "/new-job", method = RequestMethod.POST)
    public @ResponseBody
    Boolean getJobs(@RequestBody JobDto jobDto) {

        return jobsBusiness.insertJob(jobDto);
    }

}

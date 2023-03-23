package com.example.medial.controller;

import com.example.medial.model.enums.Api;
import com.example.medial.service.JobsServiceImpl;
import com.example.medial.model.dto.JobDto;
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
    private JobsServiceImpl jobsBusiness;

    //Get recent jobs
    @RequestMapping(value = "/recent-jobs", method = RequestMethod.GET)
    public @ResponseBody
    List<JobDto> getRecentJobs() {

        return jobsBusiness.getRecentJobs();
    }

    //Get recent jobs
    @RequestMapping(value = "/new-job", method = RequestMethod.POST)
    public @ResponseBody
    Boolean getJobs(@RequestBody JobDto jobDto) {

        return jobsBusiness.insertJob(jobDto);
    }



}

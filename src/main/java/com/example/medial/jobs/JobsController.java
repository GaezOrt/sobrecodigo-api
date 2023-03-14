package com.example.medial.jobs;

import com.example.medial.enums.Api;
import com.example.medial.jobs.business.JobsBusiness;
import com.example.medial.jobs.dtos.JobDto;
import com.example.medial.jobs.models.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("newJobsController")
@RequestMapping("/1.0/jobs")
@CrossOrigin(origins = Api.API)
@Controller
public class JobsController {

    @Autowired
    private JobsBusiness jobsBusiness;

    //Get recent jobs
    @RequestMapping(value = "/recent-jobs", method = RequestMethod.GET)
    public @ResponseBody
    List<JobDto> getRecentJobs() {

        return jobsBusiness.getRecentJobs();
    }


}

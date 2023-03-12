package com.example.medial.jobs;

import com.example.medial.enums.Api;
import com.example.medial.jobs.business.ProjectBusiness;
import com.example.medial.jobs.models.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("newUserController")
@RequestMapping("/1.0/projects")
@CrossOrigin(origins = Api.API)
@Controller
public class ProjectController {

    @Autowired
    private ProjectBusiness projectBusiness;

    //Get recent projects
    @RequestMapping(value = "/recent-projects", method = RequestMethod.GET)
    public @ResponseBody
    List<Job> userInfo() {

        return projectBusiness.getMostRecentProjects();
    }


}

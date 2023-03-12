package com.example.medial.projects.controllers;

import com.example.medial.enums.Api;
import com.example.medial.projects.business.ProjectBusiness;
import com.example.medial.projects.models.Project;
import com.example.medial.user.dtos.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("projectsController")
@RequestMapping("/1.0/projects")
@CrossOrigin(origins = Api.API)
@Controller
public class ProjectController {

    @Autowired
    private ProjectBusiness projectBusiness;

    //Get recent projects
    @RequestMapping(value = "/recent-projects", method = RequestMethod.GET)
    public @ResponseBody
    List<Project> userInfo() {

        return projectBusiness.getMostRecentProjects();
    }


}

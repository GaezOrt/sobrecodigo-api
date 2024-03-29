package com.example.medial.controller;

import com.example.medial.model.enums.Api;
import com.example.medial.service.ProjectServiceImpl;
import com.example.medial.model.dto.response.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("newProjectController")
@RequestMapping("/1.0/projects")
@CrossOrigin(origins = Api.API)
@Controller
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectBusiness;

    //Get recent projects
    @GetMapping("/recent")
    public @ResponseBody
    List<ProjectDto> getProjects() {
        return projectBusiness.getMostRecentProjects();
    }

    //Get recent projects
    @GetMapping("/by-user")
    public @ResponseBody
    List<ProjectDto> getProjectsByUser() {
        return projectBusiness.getProjectsByUser();
    }


    @GetMapping("/by-id/{id}")
    public @ResponseBody
    ProjectDto getProjectById(@PathVariable Long id) {
        return projectBusiness.getProjectById(id);
    }


}

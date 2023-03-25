package com.example.medial.controller;

import com.example.medial.model.enums.Api;
import com.example.medial.projects.business.ProjectBusiness;
import com.example.medial.projects.dtos.ProjectDto;
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
    private ProjectBusiness projectBusiness;

    //No creo que haga falta meter paginacion aca
    @GetMapping("/recent")
    public @ResponseBody
    List<ProjectDto> getProjects() {
        return projectBusiness.getMostRecentProjects();
    }

    @GetMapping("/by-user")
    public @ResponseBody
    List<ProjectDto> getProjectsByUser() {
        return projectBusiness.getProjectsByUser();
    }

}

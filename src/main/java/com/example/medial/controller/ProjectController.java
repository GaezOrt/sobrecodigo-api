package com.example.medial.controller;

import com.example.medial.model.entity.Project;
import com.example.medial.model.enums.Api;
import com.example.medial.projects.business.ProjectBusiness;
import com.example.medial.projects.dtos.ProjectDto;
import com.example.medial.util.paginator.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController("newProjectController")
@RequestMapping("/1.0/projects")
@CrossOrigin(origins = Api.API)
@Controller
public class ProjectController {

    @Autowired
    private ProjectBusiness projectBusiness;



    //Get recent projects
    @RequestMapping(value = "/recent-projects", method = RequestMethod.GET)
    public @ResponseBody
    List<ProjectDto> getProjects(@RequestParam(name="page", defaultValue = "0") int page) {
        Pageable pageRequest =  PageRequest.of(page,4);
        Page<Project> listProject = projectBusiness.FindAll(pageRequest);
        PageRender pageRender = new PageRender<>("/recent-projects", listProject);
        return projectBusiness.getMostRecentProjects();
    }

    //Get recent projects
    @RequestMapping(value = "/by-user", method = RequestMethod.GET)
    public @ResponseBody
    List<ProjectDto> getProjectsByUser() {

        return projectBusiness.getProjectsByUser();
    }

}

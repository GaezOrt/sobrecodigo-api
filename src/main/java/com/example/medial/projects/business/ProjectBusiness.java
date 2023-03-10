package com.example.medial.projects.business;

import com.example.medial.projects.models.Project;
import com.example.medial.projects.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectBusiness {

    @Autowired
    private ProjectsRepository projectsRepository;

    public List<Project> getMostRecentProjects(){
        return projectsRepository.findAll();
    }
}

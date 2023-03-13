package com.example.medial.projects.business;

import com.example.medial.projects.dtos.ProjectDto;
import com.example.medial.projects.models.Project;
import com.example.medial.projects.models.ProjectParticipation;
import com.example.medial.projects.repositories.ProjectsParticipationRepository;
import com.example.medial.projects.repositories.ProjectsRepository;
import com.example.medial.security.AuthFacade;
import com.example.medial.user.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectBusiness {

    @Autowired
    private ProjectsRepository projectsRepository;

    @Autowired
    private AuthFacade authFacade;

    @Autowired
    private ProjectsParticipationRepository projectsParticipationRepository;

    public List<ProjectDto> getProjectsByUser() {
        Usuario usuario = authFacade.getUsuarioLoggeado();

        List<ProjectParticipation> projects = projectsParticipationRepository.findByUserId(usuario.getId());
        List<ProjectDto> projectDtos = new ArrayList<>();
        for (ProjectParticipation project : projects) {
            ProjectDto projectDto = new ProjectDto();
            projectDto.setDescription(project.getProject().getDescription());
            projectDto.setTitle(project.getProject().getName());
            projectDto.setTags("Timer, JavaScript, Frontend");
            projectDtos.add(projectDto);
        }
        return projectDtos;
    }

    public List<ProjectDto> getMostRecentProjects() {
        List<Project> projects = projectsRepository.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        for (Project project : projects) {
            ProjectDto projectDto = new ProjectDto();
            projectDto.setDescription(project.getDescription());
            projectDto.setTitle(project.getName());
            projectDto.setTags("Timer, JavaScript, Frontend");
            projectDtos.add(projectDto);
        }
        return projectDtos;
    }

}

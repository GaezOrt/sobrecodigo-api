package com.example.medial.projects.business;

import com.example.medial.mapper.ProjectMapper;
import com.example.medial.mapper.ProjectParticipationMapper;
import com.example.medial.projects.dtos.ProjectDto;
import com.example.medial.model.entity.Project;
import com.example.medial.model.entity.ProjectParticipation;
import com.example.medial.repository.ProjectsParticipationRepository;
import com.example.medial.repository.ProjectsRepository;
import com.example.medial.security.AuthFacade;
import com.example.medial.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectBusiness {

    @Autowired
    private ProjectsRepository projectsRepository;

    @Autowired
    private AuthFacade authFacade;

    @Autowired
    ProjectParticipationMapper projectParticipationMapper;

    @Autowired
    ProjectsParticipationRepository projectsParticipationRepository;

    @Autowired
    ProjectMapper projectMapper;

    public List<ProjectDto> getProjectsByUser() {
        Usuario usuario = authFacade.getUsuarioLoggeado();

        List<ProjectParticipation> projectsParticipation = projectsParticipationRepository.findByUserId(usuario.getId());
        List<ProjectDto> projectDtos = new ArrayList<>();
        if(!projectsParticipation.isEmpty()) {
            projectDtos = projectsParticipation.stream()
                    .map(projectParticipation -> projectParticipationMapper.mapToDto(projectParticipation))
                    .collect(Collectors.toList());
        }

        return projectDtos;
    }

    public List<ProjectDto> getMostRecentProjects() {
        List<Project> projects = projectsRepository.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();

        if(!projects.isEmpty()) {
            projectDtos = projects.stream()
                   .map(project -> projectMapper.mapToDto(project))
                   .collect(Collectors.toList());
        }

        return projectDtos;
    }
}

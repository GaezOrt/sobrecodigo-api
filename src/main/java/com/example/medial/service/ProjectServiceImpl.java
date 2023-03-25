package com.example.medial.service;

import com.example.medial.exceptions.UserNotFoundException;
import com.example.medial.model.mapper.ProjectMapper;
import com.example.medial.model.mapper.ProjectParticipationMapper;
import com.example.medial.model.dto.response.ProjectDto;
import com.example.medial.model.entity.Project;
import com.example.medial.model.entity.ProjectParticipation;
import com.example.medial.repository.ProjectsParticipationRepository;
import com.example.medial.repository.ProjectsRepository;
import com.example.medial.security.AuthFacade;
import com.example.medial.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl {

    @Autowired
    private ProjectsRepository projectsRepository;

    @Autowired
    private AuthFacade authFacade;

    @Autowired
    private ProjectsParticipationRepository projectsParticipationRepository;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    ProjectParticipationMapper projectParticipationMapper;

    public List<ProjectDto> getProjectsByUser() {
        Usuario usuario = authFacade.getUsuarioLoggeado();

        List<ProjectParticipation> projects = projectsParticipationRepository.findByUserId(usuario.getId())
                .orElseThrow(() -> new UserNotFoundException("Usuario con id: " + usuario.getId() + "no encontrado."));

        List<ProjectDto> projectDtos = projects.stream()
                .map(projectParticipation -> projectParticipationMapper.toDto(projectParticipation))
                .collect(Collectors.toList());

        return projectDtos;
    }

    public List<ProjectDto> getMostRecentProjects() {
        List<Project> projects = projectsRepository.findAll();
        List<ProjectDto> projectDtos = projects.stream()
                .map(project -> projectMapper.toDto(project))
                .collect(Collectors.toList());

        return projectDtos;
    }

}

package com.example.medial.service;

import com.example.medial.exceptions.UserNotFoundException;
import com.example.medial.model.dto.response.*;
import com.example.medial.model.entity.ProjectTechnologies;
import com.example.medial.model.mapper.ProjectMapper;
import com.example.medial.model.mapper.ProjectParticipationMapper;
import com.example.medial.model.entity.Project;
import com.example.medial.model.entity.ProjectParticipation;
import com.example.medial.repository.ProjectTechnologiesRepository;
import com.example.medial.repository.ProjectsParticipationRepository;
import com.example.medial.repository.ProjectsRepository;
import com.example.medial.security.AuthFacade;
import com.example.medial.model.entity.Usuario;
import com.nimbusds.openid.connect.sdk.claims.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    ProjectTechnologiesRepository projectTechnologiesRepository;

    public List<ProjectDto> getProjectsByUser() {
        Usuario usuario = authFacade.getUsuarioLoggeado();

        List<ProjectParticipation> projects = projectsParticipationRepository.findByUserId(usuario.getId())
                .orElseThrow(() -> new UserNotFoundException("Usuario con id: " + usuario.getId() + "no encontrado."));

        List<ProjectDto> projectDtos = projects.stream()
                .map(projectParticipation -> projectParticipationMapper.toDto(projectParticipation))
                .collect(Collectors.toList());

        return projectDtos;
    }

    public ProjectDto getProjectById(Long id) {

        Project project = projectsRepository.findBySpecificId(id);

        ProjectDto projectDto = projectMapper.toDto(project);
        List<ProjectParticipation> lista = projectsParticipationRepository.findParticipantsByProjectId(project.getId());
        List<ProjectParticipationDto> projectParticipationDtos = new ArrayList<>();
        for(ProjectParticipation projectParticipation : lista){
            ProjectParticipationDto projectParticipationDto = new ProjectParticipationDto();
            projectParticipationDto.setProjectDto(this.projectMapper.toDto(projectParticipation.getProject()));

            UserInfoDto userInfoDto = new UserInfoDto();
            userInfoDto.setEmail(projectParticipation.getUserId().getEmail());
            userInfoDto.setUsername(projectParticipation.getUserId().getUsername());
            userInfoDto.setId(projectParticipation.getUserId().getId());
            userInfoDto.setUsername(projectParticipation.getUserId().getUsername());

           projectParticipationDto.setUserInfoDto(userInfoDto);
           projectParticipationDtos.add(projectParticipationDto);
        }
        projectDto.setProjectParticipationDtos(projectParticipationDtos);

        List<ProjectTechnologies> projectTechnologies = projectTechnologiesRepository.findByProject(project.getId());
        List<TechnologyDto> projectTechnologiesDto = new ArrayList<>();
        ProjectTechnologiesDto projectTechnologiesDto1 = new ProjectTechnologiesDto();
        projectTechnologiesDto1.setProjectDto(this.projectMapper.toDto(project));

        for(ProjectTechnologies projectTechnologies1 : projectTechnologies){
            TechnologyDto technologyDto = new TechnologyDto();
            technologyDto.setTechnology(projectTechnologies1.getTechnology().getTechnology());
            projectTechnologiesDto.add(technologyDto);
        }
        projectTechnologiesDto1.setTechnologiesDtos(projectTechnologiesDto);
        projectDto.setProjectParticipationDtos(projectParticipationDtos);
        projectDto.setProjectTechnologiesDtos(projectTechnologiesDto);
        return projectDto;
    }


    public List<ProjectDto> getMostRecentProjects() {
        List<Project> projects = projectsRepository.findAll();
        List<ProjectDto> projectDtos = projects.stream()
                .map(project -> projectMapper.toDto(project))
                .collect(Collectors.toList());

        return projectDtos;
    }

}

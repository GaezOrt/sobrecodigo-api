package com.example.medial.mapper;

import com.example.medial.model.entity.ProjectParticipation;
import com.example.medial.projects.dtos.ProjectDto;
import org.springframework.stereotype.Component;

@Component
public class ProjectParticipationMapper {
    public ProjectDto mapToDto(ProjectParticipation project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setDescription(project.getProject().getDescription());
        projectDto.setTitle(project.getProject().getName());
        projectDto.setTags("Timer, JavaScript, Frontend");
        return projectDto;
    }
}

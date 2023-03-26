package com.example.medial.model.mapper;

import com.example.medial.model.dto.response.ProjectDto;
import com.example.medial.model.entity.ProjectParticipation;
import org.springframework.stereotype.Component;

@Component
public class ProjectParticipationMapper {
    public ProjectDto toDto(ProjectParticipation project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setDescription(project.getProject().getDescription());
        projectDto.setTitle(project.getProject().getName());
        projectDto.setTags("Timer, JavaScript, Frontend");
        return projectDto;
    }

}

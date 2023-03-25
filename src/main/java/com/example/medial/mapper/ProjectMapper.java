package com.example.medial.mapper;

import com.example.medial.model.entity.Project;
import com.example.medial.projects.dtos.ProjectDto;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public ProjectDto mapToDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setDescription(project.getDescription());
        projectDto.setTitle(project.getName());
        projectDto.setTags("Timer, JavaScript, Frontend");
        return projectDto;
    }
}

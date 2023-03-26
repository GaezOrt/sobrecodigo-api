package com.example.medial.model.mapper;

import com.example.medial.model.dto.response.ProjectDto;
import com.example.medial.model.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public ProjectDto toDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setDescription(project.getDescription());
        projectDto.setTitle(project.getName());
        projectDto.setImage(project.getImgPortada());
        projectDto.setQuickDescription(project.getQuickDescription());
        projectDto.setTags("Timer, JavaScript, Frontend");
        projectDto.setId(project.getId());
        projectDto.setGithub(project.getGithub());

        return projectDto;
    }
}

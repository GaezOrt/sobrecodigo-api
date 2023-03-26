package com.example.medial.model.mapper;

import com.example.medial.model.dto.response.ProjectDto;
import com.example.medial.model.dto.response.ProjectTechnologiesDto;
import com.example.medial.model.entity.Project;
import com.example.medial.model.entity.ProjectTechnologies;
import com.example.medial.repository.ProjectTechnologiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectMapper {
    @Autowired
    private ProjectTechnologiesRepository projectTechnologiesRepository;

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

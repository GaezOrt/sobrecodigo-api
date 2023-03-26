package com.example.medial.model.dto.response;

import java.util.List;

public class ProjectTechnologiesDto {

    private Long id;

    private ProjectDto projectDto;

    private List<TechnologyDto> technologiesDtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectDto getProjectDto() {
        return projectDto;
    }

    public void setProjectDto(ProjectDto projectDto) {
        this.projectDto = projectDto;
    }

    public List<TechnologyDto> getTechnologiesDtos() {
        return technologiesDtos;
    }

    public void setTechnologiesDtos(List<TechnologyDto> technologiesDtos) {
        this.technologiesDtos = technologiesDtos;
    }
}

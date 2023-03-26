package com.example.medial.model.dto.response;

import java.util.List;

public class ProjectDto {

    private String title;
    private String description;
    private String quickDescription;
    private String tags;
    private String image;
    private Long id;
    private String github;
    private List<ProjectParticipationDto> projectParticipationDtos;
    private List<TechnologyDto> projectTechnologiesDtos;

    public List<TechnologyDto> getProjectTechnologiesDtos() {
        return projectTechnologiesDtos;
    }

    public void setProjectTechnologiesDtos(List<TechnologyDto> projectTechnologiesDtos) {
        this.projectTechnologiesDtos = projectTechnologiesDtos;
    }

    public List<ProjectParticipationDto> getProjectParticipationDtos() {
        return projectParticipationDtos;
    }

    public void setProjectParticipationDtos(List<ProjectParticipationDto> projectParticipationDtos) {
        this.projectParticipationDtos = projectParticipationDtos;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuickDescription() {
        return quickDescription;
    }

    public void setQuickDescription(String quickDescription) {
        this.quickDescription = quickDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.example.medial.model.dto.response;

import com.example.medial.model.entity.Project;
import com.example.medial.model.entity.Usuario;

import javax.persistence.*;

public class ProjectParticipationDto {

    private Long id;

    private UserInfoDto userInfoDto;

    private ProjectDto projectDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfoDto getUserInfoDto() {
        return userInfoDto;
    }

    public void setUserInfoDto(UserInfoDto userInfoDto) {
        this.userInfoDto = userInfoDto;
    }

    public ProjectDto getProjectDto() {
        return projectDto;
    }

    public void setProjectDto(ProjectDto projectDto) {
        this.projectDto = projectDto;
    }
}

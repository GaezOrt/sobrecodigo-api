package com.example.medial.model.dto;


import com.example.medial.model.entity.UserTechnologies;

import java.util.List;

public class UserInfoDto {
    private String email;
    private String username;
    private String linkedIn;
    private String github;

    private List<UserTechnologyDto> tecnologias;

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public List<UserTechnologyDto> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<UserTechnologyDto> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

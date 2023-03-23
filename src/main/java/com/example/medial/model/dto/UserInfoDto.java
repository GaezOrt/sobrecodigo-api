package com.example.medial.model.dto;


import com.example.medial.model.entity.UserTechnologies;

import java.util.List;

public class UserInfoDto {
    private String email;
    private String username;

    private List<UserTechnologyDto> tecnologias;

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

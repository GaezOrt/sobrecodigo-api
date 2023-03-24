package com.example.medial.model.dto;



public class UserCreateFirstStepDto {
    private String email;
    private String rubro;
    private String password;
    private String username;
    private TechnologiesDto technologiesDto;
    private String linkedIn;
    private String github;

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public TechnologiesDto getTechnologiesDto() {
        return technologiesDto;
    }

    public void setTechnologiesDto(TechnologiesDto technologiesDto) {
        this.technologiesDto = technologiesDto;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

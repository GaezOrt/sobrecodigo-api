package com.example.medial.user.dtos.response;

public class UserCardDto {

    private String username;
    private String position;
    private Long desafiosCompletados;
    private Long proyectosCompletados;
    private Long contribucionesGit;
    private String LinkedInLink;
    private String GitHubLink;
    private String profileImageUrl;

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getGitHubLink() {
        return GitHubLink;
    }

    public void setGitHubLink(String gitHubLink) {
        GitHubLink = gitHubLink;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getDesafiosCompletados() {
        return desafiosCompletados;
    }

    public void setDesafiosCompletados(Long desafiosCompletados) {
        this.desafiosCompletados = desafiosCompletados;
    }

    public Long getProyectosCompletados() {
        return proyectosCompletados;
    }

    public void setProyectosCompletados(Long proyectosCompletados) {
        this.proyectosCompletados = proyectosCompletados;
    }

    public Long getContribucionesGit() {
        return contribucionesGit;
    }

    public void setContribucionesGit(Long contribucionesGit) {
        this.contribucionesGit = contribucionesGit;
    }

    public String getLinkedInLink() {
        return LinkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        LinkedInLink = linkedInLink;
    }
}

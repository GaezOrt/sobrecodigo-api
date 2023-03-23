package com.example.medial.model.dto;


import java.util.Date;

public class UserCreateSecondStepDto {

    private String firstName;
    private String lastName;
    private Date birthDate;
    private Long nacionality;
    private String document;
    private Long documentType;

    public Long getNacionality() {
        return nacionality;
    }

    public void setNacionality(Long nacionality) {
        this.nacionality = nacionality;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Long getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Long documentType) {
        this.documentType = documentType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public static class UserCardDto {

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
}

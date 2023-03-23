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
}

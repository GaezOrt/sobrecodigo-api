package com.example.medial.jobs.models;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private Long positionId;
    @Column(name = "description")
    private String description;

    @Column(name = "modality_work")
    private Long modalityWorkId;

    @Column(name = "currency")
    private Long currencyId;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "relocation")
    private Boolean relocation;

    @Column(name = "requirement")
    private String requirement;
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPosition(Long position) {this.positionId = position;}

    public void setModality_work(Long modality_work) {this.modalityWorkId = modality_work;}

    public void setCurrency(Long currency) {this.currencyId = currency;}

    public void setSalary(Double salary) {this.salary = salary;}

    public void setRelocation(Boolean relocation) {this.relocation = relocation;}

    public void setRequirement(String requirement) {this.requirement = requirement;}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getDescription() {
        return description;
    }

    public Long getModalityWorkId() {
        return modalityWorkId;
    }

    public void setModalityWorkId(Long modalityWorkId) {
        this.modalityWorkId = modalityWorkId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Double getSalary() {
        return salary;
    }

    public Boolean getRelocation() {
        return relocation;
    }

    public String getRequirement() {
        return requirement;
    }
}

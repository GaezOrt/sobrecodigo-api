package com.example.medial.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position")
    private JobPosition position;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modality_work")
    private ModalityWork modalityWork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency")
    private Currency currency;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "relocation")
    private Boolean relocation;

    @Column(name = "requirement")
    private String requirement;

    @Column(name = "enterprise")
    private String enterprise;

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setSalary(Double salary) {this.salary = salary;}

    public void setRelocation(Boolean relocation) {this.relocation = relocation;}

    public void setRequirement(String requirement) {this.requirement = requirement;}

    public Long getId() {
        return id;
    }

    public JobPosition getPosition() {
        return position;
    }

    public void setPosition(JobPosition position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public ModalityWork getModalityWork() {
        return modalityWork;
    }

    public void setModalityWork(ModalityWork modalityWork) {
        this.modalityWork = modalityWork;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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

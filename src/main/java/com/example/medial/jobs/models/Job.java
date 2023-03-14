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


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getName() {
        return name;
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

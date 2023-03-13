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
    private String position;
    @Column(name = "description")
    private String description;

    @Column(name = "modality_work")
    private String modality_work;

    @Column(name = "currency")
    private String currency;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "relocation")
    private String relocation;

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

    public void setPosition(String position) {this.position = position;}

    public void setModality_work(String modality_work) {this.modality_work = modality_work;}

    public void setCurrency(String currency) {this.currency = currency;}

    public void setSalary(Double salary) {this.salary = salary;}

    public void setRelocation(String relocation) {this.relocation = relocation;}

    public void setRequirement(String requirement) {this.requirement = requirement;}
}

package com.example.medial.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "job_postulations")
public class JobPostulations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "job_id")
    private Job jobId;
    @JoinColumn(name = "postulation_id")
    private Postulation postulationId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Job getJobId() {
        return jobId;
    }

    public void setJobId(Job jobId) {
        this.jobId = jobId;
    }

    public Postulation getPostulationId() {
        return postulationId;
    }

    public void setPostulationId(Postulation postulationId) {
        this.postulationId = postulationId;
    }
}

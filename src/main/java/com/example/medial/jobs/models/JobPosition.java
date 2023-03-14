package com.example.medial.jobs.models;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class JobPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private String position;
}

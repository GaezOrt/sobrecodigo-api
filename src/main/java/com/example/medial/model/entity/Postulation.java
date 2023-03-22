package com.example.medial.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "postulations")
public class Postulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "cv")
    private Long cv;
    @JoinColumn(name = "expected_remuneration")
    private Double expectedRemuneration;
    @JoinColumn(name = "letter")
    private String letter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCv() {
        return cv;
    }

    public void setCv(Long cv) {
        this.cv = cv;
    }

    public Double getExpectedRemuneration() {
        return expectedRemuneration;
    }

    public void setExpectedRemuneration(Double expectedRemuneration) {
        this.expectedRemuneration = expectedRemuneration;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}

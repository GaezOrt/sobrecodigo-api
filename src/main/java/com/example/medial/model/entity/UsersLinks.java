package com.example.medial.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "users_links")
public class UsersLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Usuario userId;

    @Column(name = "linkedin")
    private String linkedIn;

    @Column(name = "mail")
    private String mail;

    @Column(name = "portfolio")
    private String portfolio;

    @Column(name = "github")
    private String github;

    public Usuario getUserId() {
        return userId;
    }

    public void setUserId(Usuario userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}

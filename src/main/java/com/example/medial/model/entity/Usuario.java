package com.example.medial.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "dim_user")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "dni")
    private String dni;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "professional_flag")
    private boolean professionalFlag;

    @Column(name = "country")
    private Long country;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "profile_picture")
    private ProfilePicture profilePicture;

    public ProfilePicture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(ProfilePicture profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public boolean isProfessionalFlag() {
        return professionalFlag;
    }

    public void setProfessionalFlag(boolean professionalFlag) {
        this.professionalFlag = professionalFlag;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

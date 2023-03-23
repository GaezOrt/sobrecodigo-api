package com.example.medial.model.dto;

import com.example.medial.model.entity.Technology;
import com.example.medial.model.entity.Usuario;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class UserTechnologyDto {

    private TechnologyDto technology;


    public TechnologyDto getTechnology() {
        return technology;
    }

    public void setTechnology(TechnologyDto technology) {
        this.technology = technology;
    }


}

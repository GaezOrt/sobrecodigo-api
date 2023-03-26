package com.example.medial.model.dto.response;

import com.example.medial.model.entity.Technology;

import javax.persistence.*;

public class TechnologyColorsIconDto {

    private Long id;
    private Technology technology;
    private String color;
    private String icon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

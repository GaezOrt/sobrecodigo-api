package com.example.medial.model.dto.response;

public class UserTechnologyDto {

    private TechnologyDto technology;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public TechnologyDto getTechnology() {
        return technology;
    }

    public void setTechnology(TechnologyDto technology) {
        this.technology = technology;
    }


}

package com.example.medial.model.mapper;

import com.example.medial.model.dto.response.TechnologyDto;
import com.example.medial.model.dto.response.UserTechnologyDto;
import com.example.medial.model.entity.UserTechnologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTechnologiesMapper {

    public UserTechnologyDto toDto(UserTechnologies userTechnologies) {
        UserTechnologyDto userTechnologyDto = new UserTechnologyDto();
        TechnologyDto technologyDto = new TechnologyDto();
        technologyDto.setTechnology(userTechnologies.getTechnology().getTechnology());
        technologyDto.setColor(userTechnologies.getTechnology().getColor());
        technologyDto.setIcon(userTechnologies.getTechnology().getIcon());
        userTechnologyDto.setTechnology(technologyDto);
        return userTechnologyDto;
    }
}

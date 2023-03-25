package com.example.medial.mapper;

import com.example.medial.model.dto.response.TechnologyDto;
import com.example.medial.model.dto.response.UserTechnologyDto;
import com.example.medial.model.entity.UserTechnologies;
import org.springframework.stereotype.Component;

@Component
public class UserTechnologiesMapper {
    public UserTechnologyDto toDto(UserTechnologies userTechnologies) {
        UserTechnologyDto userTechnologyDto = new UserTechnologyDto();
        TechnologyDto technologyDto = new TechnologyDto();
        technologyDto.setTechnology(userTechnologies.getTechnology().getTechnology());
        userTechnologyDto.setTechnology(technologyDto);
        return userTechnologyDto;
    }
}

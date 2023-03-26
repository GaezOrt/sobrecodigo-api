package com.example.medial.model.mapper;

import com.example.medial.model.dto.response.TechnologyDto;
import com.example.medial.model.dto.response.UserTechnologyDto;
import com.example.medial.model.entity.UserTechnologies;
import com.example.medial.repository.TechnologyColorsIconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTechnologiesMapper {
    @Autowired
    private TechnologyColorsIconRepository iconRepository;

    public UserTechnologyDto toDto(UserTechnologies userTechnologies) {
        UserTechnologyDto userTechnologyDto = new UserTechnologyDto();
        TechnologyDto technologyDto = new TechnologyDto();
        technologyDto.setTechnology(userTechnologies.getTechnology().getTechnology());
        userTechnologyDto.setTechnology(technologyDto);
        userTechnologyDto.setIcon(iconRepository.findIconByTechnology(userTechnologies.getTechnology().getId()).getIcon());
        return userTechnologyDto;
    }
}

package com.example.medial.controller;

import com.example.medial.model.dto.response.TechnologyColorsIconDto;
import com.example.medial.model.dto.response.UserTechnologyDto;
import com.example.medial.model.entity.Technology;
import com.example.medial.model.enums.Api;
import com.example.medial.repository.UserTechnologyRepository;
import com.example.medial.service.TechnologiesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("techController")
@RequestMapping("/1.0/technologies")
@CrossOrigin(origins = Api.API)
@Controller
public class TechnologiesController
{

    @Autowired
    private TechnologiesServiceImpl technologiesService;

    @Autowired
    private UserTechnologyRepository userTechnologyRepository;

    //Get technologies
    @GetMapping
    public @ResponseBody
    List<Technology> getTechnologies() {
        return technologiesService.getTechnologies();
    }

    @GetMapping("/by-user")
    public @ResponseBody
    List<UserTechnologyDto> getTechByUser() {
        return technologiesService.getTechnologiesByUser();
    }

    @GetMapping("/by-user/{userId}")
    public @ResponseBody
    List<UserTechnologyDto> getTechByUser(@PathVariable Long userId) {
        return technologiesService.getTechnologiesByUser(userId);
    }


    @GetMapping("/icons/by-technology/{technologyId}")
    public @ResponseBody
    TechnologyColorsIconDto getIconByTechnology(@PathVariable Long technologyId) {
        return technologiesService.getTechnologyIcon(technologyId);
    }

}

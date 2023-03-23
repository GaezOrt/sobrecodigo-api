package com.example.medial.controller;

import com.example.medial.model.entity.Technology;
import com.example.medial.model.enums.Api;
import com.example.medial.service.JobsServiceImpl;
import com.example.medial.model.dto.JobDto;
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

    //Get technologies
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<Technology> getTechnologies() {
        return technologiesService.getTechnologies();
    }

}
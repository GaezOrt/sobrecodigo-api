package com.example.medial.service;

import com.example.medial.model.mapper.UserTechnologiesMapper;
import com.example.medial.model.dto.response.TechnologiesDto;
import com.example.medial.model.dto.response.UserTechnologyDto;
import com.example.medial.model.entity.Technology;
import com.example.medial.model.entity.UserTechnologies;
import com.example.medial.model.entity.Usuario;
import com.example.medial.repository.TechnologiesRepository;
import com.example.medial.repository.UserTechnologyRepository;
import com.example.medial.security.AuthFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnologiesServiceImpl {


    @Autowired
    private AuthFacade authFacade;
    @Autowired
    private TechnologiesRepository technologiesRepository;
    @Autowired
    private UserTechnologyRepository userTechnologyRepository;

    @Autowired
    private UserTechnologiesMapper userTechnologiesMapper;


    public List<Technology> getTechnologies() {

        return technologiesRepository.findAll();
    }
    public List<UserTechnologyDto> getTechnologiesByUser() {

        Usuario usuario = authFacade.getUsuarioLoggeado();

        //Si no hay, que devuelve?
        List<UserTechnologies> userTecnologies = userTechnologyRepository.findByTechnologiesByUser(usuario.getId());

        if(userTecnologies.size() == 0){
            return new ArrayList<>();
        } else {
            List<UserTechnologyDto > userTechnologyDtos =
                    userTecnologies.stream()
                            .map(userTechnologies -> userTechnologiesMapper.toDto(userTechnologies))
                            .collect(Collectors.toList());
            return userTechnologyDtos;
        }
    }

    public List<UserTechnologyDto> getTechnologiesForProfileByUser(Usuario usuario) {

        List<UserTechnologies> userTecnologies = userTechnologyRepository.findByTechnologiesByUser(usuario.getId());

        if(userTecnologies.size() == 0){
            return new ArrayList<>();
        } else {
            List<UserTechnologyDto > userTechnologyDtos =
                    userTecnologies.stream()
                            .map(userTechnologies -> userTechnologiesMapper.toDto(userTechnologies))
                            .collect(Collectors.toList());
            return userTechnologyDtos;
        }
    }

    public boolean saveTechnologies(Usuario usuario, TechnologiesDto technologiesDto) throws IllegalAccessException {

        Field[] fields = technologiesDto.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(technologiesDto);
            System.out.println("Field Name: " + field.getName() + ", Value: " + value);
            List<Technology> tecnologias = technologiesRepository.findAll();

           if(Boolean.parseBoolean(value.toString())){
            for (Technology technology : tecnologias) {
                if (field.getName().toLowerCase().equals(technology.getTechnology().replace(" ", "").toLowerCase())) {
                    UserTechnologies userTechnologies = new UserTechnologies();
                    userTechnologies.setTechnology(technology);
                    userTechnologies.setUserId(usuario);
                    userTechnologyRepository.save(userTechnologies);
                }
            }
            }
        }
        return true;
    }
}

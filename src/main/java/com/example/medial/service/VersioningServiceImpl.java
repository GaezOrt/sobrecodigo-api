package com.example.medial.service;

import com.example.medial.model.entity.Versionado;
import com.example.medial.repository.VersionadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VersioningServiceImpl {

    @Autowired
    private VersionadoRepository versionadoRepository;


    public boolean versionCorrecta(Map<String, String> params) {
        String version = params.get("version");
        String os = params.get("os");
        Versionado versionado = versionadoRepository.findByVersionAndOs(version, os);
        if (versionado == null) {
            return false;
        } else {
            return true;
        }
    }
}

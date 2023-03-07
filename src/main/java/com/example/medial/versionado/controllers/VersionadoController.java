package com.example.medial.versionado.controllers;

import com.example.medial.user.dtos.ChangePasswordDto;
import com.example.medial.versionado.business.VersionadoBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("versionadoPasswordController")
@RequestMapping("/1.0/versionado")
public class VersionadoController {

    @Autowired
    private VersionadoBusiness versionadoBusiness;

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public boolean versionOk(@RequestParam Map<String,String> params) throws Exception {

        return versionadoBusiness.versionCorrecta(params);
    }
}

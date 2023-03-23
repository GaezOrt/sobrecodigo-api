package com.example.medial.controller;

import com.example.medial.model.dto.*;
import com.example.medial.model.enums.Api;
import com.example.medial.service.UserServiceImpl;
import com.example.medial.user.dtos.response.UserCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//spring.datasource.url=jdbc:sqlserver://tunero.database.windows.net:1433;database=turnos_db

@RestController("newUserController")
@RequestMapping("/1.0/users")
@CrossOrigin(origins = Api.API)
@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userBusiness;

    @RequestMapping(value = "/log-in", method = RequestMethod.POST)
    public @ResponseBody
    UserLoggedInDto checkUser(@RequestBody UserLogInDto userLogInDto) throws Exception {

        return userBusiness.login(userLogInDto);
    }

    @RequestMapping(value = "/register-first-step", method = RequestMethod.POST)
    public @ResponseBody
    boolean createUser(@RequestBody UserCreateFirstStepDto userCreateFirstStepDto) throws Exception {

        return userBusiness.registerFirstStep(userCreateFirstStepDto);
    }


    //user info
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public @ResponseBody
    UserInfoDto userInfo() {

        return userBusiness.userInfo();
    }
    @RequestMapping(value = "/active", method = RequestMethod.GET)
    public @ResponseBody
    List<UserCreateSecondStepDto.UserCardDto> getActiveUsers() {

        return userBusiness.getActiveUsers();
    }

}

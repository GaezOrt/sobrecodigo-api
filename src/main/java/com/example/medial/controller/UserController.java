package com.example.medial.controller;

import com.example.medial.model.dto.request.UserCreateFirstStepDto;
import com.example.medial.model.dto.request.UserLogInDto;
import com.example.medial.model.dto.response.UserCreateSecondStepDto;
import com.example.medial.model.dto.response.UserInfoDto;
import com.example.medial.model.dto.response.UserLoggedInDto;
import com.example.medial.model.enums.Api;
import com.example.medial.service.UserServiceImpl;
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

        return userBusiness.registerUser(userCreateFirstStepDto);
    }


    //user info
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public @ResponseBody
    UserInfoDto userInfo() {

        return userBusiness.userInfo();
    }


    @RequestMapping(value = "/info-by-id/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    UserInfoDto userInfoById(@PathVariable Long userId) {

        return userBusiness.getByUserId(userId);
    }
    
    @RequestMapping(value = "/active", method = RequestMethod.GET)
    public @ResponseBody
    List<UserCreateSecondStepDto.UserCardDto> getActiveUsers() {

        return userBusiness.getActiveUsers();
    }

    @RequestMapping(value = "/most-active", method = RequestMethod.GET)
    public @ResponseBody
    List<UserCreateSecondStepDto.UserCardDto> getMostActiveUsers() {

        return userBusiness.getMostActiveUsers();
    }

}

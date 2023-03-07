package com.example.medial.user.controllers;

import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.example.medial.enums.Api;
import com.example.medial.user.business.UserBusiness;
import com.example.medial.user.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.time.LocalDateTime;

//spring.datasource.url=jdbc:sqlserver://tunero.database.windows.net:1433;database=turnos_db

@RestController("newUserController")
@RequestMapping("/1.0/users")
@CrossOrigin(origins = Api.API)
@Controller
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

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

}

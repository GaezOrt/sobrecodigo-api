package com.example.medial.controller;

import com.example.medial.user.business.EmailChangeBusiness;
import com.example.medial.user.dtos.ChangePasswordCodeDto;
import com.example.medial.user.dtos.ChangePasswordDto;
import com.example.medial.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("newchangePasswordController")
@RequestMapping("/1.0/users/change-password")
public class EmailChangeController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailChangeBusiness emailChangeBusiness;

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public boolean changePassword(@RequestBody ChangePasswordDto changePasswordDto) throws Exception {

        return emailChangeBusiness.recoverPassword(changePasswordDto);
    }

    @RequestMapping(value = "/send-code", method = RequestMethod.POST)
    public boolean passwordChangeCode(@RequestBody ChangePasswordCodeDto changePasswordDto) throws Exception {

        return emailChangeBusiness.checkCode(changePasswordDto);
    }

}
package com.example.medial.controller;

import com.example.medial.service.EmailChangeServiceImpl;
import com.example.medial.model.dto.request.ChangePasswordCodeDto;
import com.example.medial.model.dto.request.ChangePasswordDto;
import com.example.medial.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("newchangePasswordController")
@RequestMapping("/1.0/users/change-password")
public class EmailChangeController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailChangeServiceImpl emailChangeBusiness;

    @PostMapping("/request")
    public boolean changePassword(@RequestBody ChangePasswordDto changePasswordDto) throws Exception {

        return emailChangeBusiness.recoverPassword(changePasswordDto);
    }

    @PostMapping("/send-code")
    public boolean passwordChangeCode(@RequestBody ChangePasswordCodeDto changePasswordDto) throws Exception {

        return emailChangeBusiness.checkCode(changePasswordDto);
    }

}

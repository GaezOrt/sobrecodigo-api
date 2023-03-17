package com.example.medial.security;

import com.example.medial.model.entity.Usuario;
import com.example.medial.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthFacade {

    @Autowired
    private UsersRepository usersRepository;

    public Authentication getAuthentication(){
    return SecurityContextHolder.getContext().getAuthentication();
    }

    public Usuario getUsuarioLoggeado(){
        return this.usersRepository.findByEmail(this.getAuthentication().getName());
    }
}

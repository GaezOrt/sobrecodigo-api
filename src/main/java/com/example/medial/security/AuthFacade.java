package com.example.medial.security;

import com.example.medial.user.models.Usuario;
import com.example.medial.user.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.Access;
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

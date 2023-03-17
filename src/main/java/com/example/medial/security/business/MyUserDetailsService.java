package com.example.medial.security.business;

import com.example.medial.model.entity.Password;
import com.example.medial.model.entity.Usuario;
import com.example.medial.repository.PasswordRepository;
import com.example.medial.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordRepository passwordRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       final Usuario usuario= usersRepository.findByEmail(username);
       Password password = passwordRepository.findPasswordByUserId(usuario.getId());

       if(usuario==null){
           throw new UsernameNotFoundException("Usuario no encontado");
       }

        return new User(username,password.getPassword(),new ArrayList<>());
    }
}

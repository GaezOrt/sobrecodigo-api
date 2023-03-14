package com.example.medial.user.business;

import com.example.medial.security.AuthFacade;
import com.example.medial.security.JWTUtil;
import com.example.medial.user.dtos.*;
import com.example.medial.user.models.Password;
import com.example.medial.user.models.Usuario;
import com.example.medial.user.repositories.PasswordRepository;
import com.example.medial.user.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
public class UserBusiness {
    @Autowired
    UsersRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    PasswordRepository passwordRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthFacade authFacade;

    public boolean registerFirstStep(UserCreateFirstStepDto userCreateFirstStepDto) throws Exception {
        try {
            Usuario usuario = new Usuario();
            usuario.setSuperUserFlag(false);
            usuario.setProfessionalFlag(false);
            usuario.setDni(null);

            usuario.setEmail(userCreateFirstStepDto.getEmail());
            usuario.setUsername(userCreateFirstStepDto.getUsername());

            usuario=userRepository.save(usuario);
            Password password= new Password();
            password.setUserId(usuario);
            password.setPassword(userCreateFirstStepDto.getPassword());
            passwordRepository.save(password);

            UserCreatedDto userCreatedDto = new UserCreatedDto();
            userCreatedDto.setToken(usuario.getId().toString());
            return true;
        } catch (Exception e) {
            throw new Exception("Error al registrar usuario. Email en uso");
        }
    }

    public UserCreateFirstStepDto getInfoFirstStep() {
        Usuario usuario= authFacade.getUsuarioLoggeado();
        UserCreateFirstStepDto userCreateFirstStepDto  = new UserCreateFirstStepDto();
        userCreateFirstStepDto.setEmail(usuario.getEmail());
        userCreateFirstStepDto.setPassword(passwordRepository.findPasswordByUserId(usuario.getId()).getPassword());

        return userCreateFirstStepDto;
    }

    public UserLoggedInDto login(UserLogInDto userLogInDto) throws Exception {

        Usuario usuario = userRepository.userExists(userLogInDto.getEmail(), userLogInDto.getPassword());

        if (usuario != null) {
            UserLoggedInDto userLoggedInDto = new UserLoggedInDto();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), userLogInDto.getPassword()));

            String token = jwtUtil.createToken(usuario.getId(), usuario.getEmail());
            userLoggedInDto.setToken(token);

            return userLoggedInDto;
        } else {
            throw new Exception("Usuario o contraseña inválida");
        }

    }

    public UserInfoDto userInfo() {
        Usuario usuario= authFacade.getUsuarioLoggeado();

        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setEmail(usuario.getEmail());
        return userInfoDto;
    }
}

package com.example.medial.service;

import com.example.medial.model.dto.*;
import com.example.medial.model.entity.ProfilePicture;
import com.example.medial.repository.ProfilePictureRepository;
import com.example.medial.security.AuthFacade;
import com.example.medial.security.JWTUtil;
import com.example.medial.model.entity.Password;
import com.example.medial.model.entity.Usuario;
import com.example.medial.repository.PasswordRepository;
import com.example.medial.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class UserServiceImpl {
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

    @Autowired
    private ProfilePictureRepository profilePictureRepository;

    @Autowired
    private TechnologiesServiceImpl technologiesService;

    public boolean registerFirstStep(UserCreateFirstStepDto userCreateFirstStepDto) throws Exception {
        try {
            Usuario usuario = new Usuario();
            usuario.setProfessionalFlag(false);
            usuario.setDni(null);

            usuario.setEmail(userCreateFirstStepDto.getEmail());
            usuario.setUsername(userCreateFirstStepDto.getUsername());
            ProfilePicture img = getImages();
            usuario.setProfilePicture(img);
            usuario=userRepository.save(usuario);

            technologiesService.saveTechnologies(usuario, userCreateFirstStepDto.getTechnologiesDto());
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

    public List<UserCreateSecondStepDto.UserCardDto> getActiveUsers() {

        List<Usuario> usuariosActivos = userRepository.findAll();
        List<UserCreateSecondStepDto.UserCardDto> userCardDtos = new ArrayList<>();
        for( Usuario usuario : usuariosActivos){
            UserCreateSecondStepDto.UserCardDto userCardDto = new UserCreateSecondStepDto.UserCardDto();
            userCardDto.setPosition("Trainee");
            userCardDto.setContribucionesGit((long)20);
            userCardDto.setUsername(usuario.getUsername());
            userCardDto.setProfileImageUrl(usuario.getProfilePicture().getUrl());
            userCardDto.setGitHubLink("https://www.linkedin.com/company/sobrecodigo/");
            userCardDto.setProyectosCompletados((long)20);
            userCardDto.setDesafiosCompletados((long)243);

            userCardDtos.add(userCardDto);
        }
        return userCardDtos;
    }

    public ProfilePicture getImages() {
        List<ProfilePicture> imgsList= (List<ProfilePicture>) profilePictureRepository.findAll();
        Random rand = new Random();
        return imgsList.get(rand.nextInt(imgsList.size()));
    }

}

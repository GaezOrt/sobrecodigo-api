package com.example.medial.service;

import com.example.medial.model.dto.request.UserCreateFirstStepDto;
import com.example.medial.model.dto.request.UserLogInDto;
import com.example.medial.model.dto.response.*;
import com.example.medial.model.entity.*;
import com.example.medial.repository.*;
import com.example.medial.security.AuthFacade;
import com.example.medial.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
    private TechnologiesRepository technologiesRepository;


    @Autowired
    private TechnologiesServiceImpl technologiesService;

    @Autowired
    private UsersLinksRepository usersLinksRepository;

    public boolean registerUser(UserCreateFirstStepDto userCreateFirstStepDto) throws Exception {
        try {
            Usuario usuario = new Usuario();
            usuario.setProfessionalFlag(false);
            usuario.setDni(null);

            usuario.setEmail(userCreateFirstStepDto.getEmail());
            usuario.setUsername(userCreateFirstStepDto.getUsername());
            ProfilePicture img = getImages();
            usuario.setProfilePicture(img);
            usuario=userRepository.save(usuario);

            UsersLinks usersLinks = new UsersLinks();
            usersLinks.setLinkedIn(userCreateFirstStepDto.getLinkedIn());
            usersLinks.setUserId(usuario);
            usersLinks.setGithub(userCreateFirstStepDto.getGithub());
            usersLinksRepository.save(usersLinks);

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
        userInfoDto.setUsername(usuario.getUsername());
        UsersLinks usersLinks = usersLinksRepository.findByUserId(usuario.getId());
        userInfoDto.setId(usuario.getId());
        userInfoDto.setGithub(usersLinks.getGithub());
        userInfoDto.setLinkedIn(usersLinks.getLinkedIn());
        List<UserTechnologyDto> listaTecnologias= technologiesService.getTechnologiesByUser();
        userInfoDto.setTecnologias(listaTecnologias);
        userInfoDto.setEmail(usuario.getEmail());

        return userInfoDto;
    }


    public UserInfoDto getByUserId(Long userId) {
        Usuario usuario= userRepository.findByUniqueId(userId);

        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUsername(usuario.getUsername());
        UsersLinks usersLinks = usersLinksRepository.findByUserId(usuario.getId());

        userInfoDto.setGithub(usersLinks.getGithub());
        userInfoDto.setLinkedIn(usersLinks.getLinkedIn());
        userInfoDto.setImage(usuario.getProfilePicture().getUrl());
        List<UserTechnologyDto> listaTecnologias= technologiesService.getTechnologiesForProfileByUser(usuario);
        userInfoDto.setTecnologias(listaTecnologias);

        userInfoDto.setEmail(usuario.getEmail());
        return userInfoDto;
    }


    public List<UserCreateSecondStepDto.UserCardDto> getActiveUsers() {

        List<Usuario> usuariosActivos = userRepository.findAll();
        List<UserCreateSecondStepDto.UserCardDto> userCardDtos = new ArrayList<>();
        for( Usuario usuario : usuariosActivos){
            UserCreateSecondStepDto.UserCardDto userCardDto = new UserCreateSecondStepDto.UserCardDto();
            userCardDto.setPosition("Trainee");
            userCardDto.setId(usuario.getId());
            userCardDto.setContribucionesGit((long)20);
            userCardDto.setUsername(usuario.getUsername());
            userCardDto.setProfileImageUrl(usuario.getProfilePicture().getUrl());
            userCardDto.setGitHubLink("https://www.linkedin.com/company/sobrecodigo/");
            userCardDto.setProyectosCompletados((long)0);
            userCardDto.setDesafiosCompletados((long)0);

            List<UserTechnologyDto> list = technologiesService.getTechnologiesByUser(usuario.getId());
            userCardDto.setTechnologyDtos(list);
            userCardDtos.add(userCardDto);
        }
        Collections.reverse(userCardDtos);
        return userCardDtos;
    }




    public ProfilePicture getImages() {
        List<ProfilePicture> imgsList= (List<ProfilePicture>) profilePictureRepository.findAll();
        Random rand = new Random();
        return imgsList.get(rand.nextInt(imgsList.size()));
    }


    public List<UserCreateSecondStepDto.UserCardDto> getMostActiveUsers() {

        List<Usuario> usuariosActivos = userRepository.findMostActive();
        List<UserCreateSecondStepDto.UserCardDto> userCardDtos = new ArrayList<>();
        for( Usuario usuario : usuariosActivos){
            UserCreateSecondStepDto.UserCardDto userCardDto = new UserCreateSecondStepDto.UserCardDto();
            userCardDto.setPosition("Trainee");
            userCardDto.setId(usuario.getId());
            userCardDto.setContribucionesGit((long)20);
            userCardDto.setUsername(usuario.getUsername());
            userCardDto.setProfileImageUrl(usuario.getProfilePicture().getUrl());
            userCardDto.setGitHubLink("https://www.linkedin.com/company/sobrecodigo/");
            userCardDto.setProyectosCompletados((long)20);
            userCardDto.setDesafiosCompletados((long)243);

            List<UserTechnologyDto> technologies = technologiesService.getTechnologiesByUser(usuario.getId());
            userCardDto.setTechnologyDtos(technologies);
            userCardDtos.add(userCardDto);
        }
        return userCardDtos;
    }


}

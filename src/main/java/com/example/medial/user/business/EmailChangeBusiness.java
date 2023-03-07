package com.example.medial.user.business;

import com.example.medial.user.dtos.ChangePasswordCodeDto;
import com.example.medial.user.dtos.ChangePasswordDto;
import com.example.medial.user.dtos.UserCreateDto;
import com.example.medial.user.dtos.UserLogInDto;
import com.example.medial.user.models.Password;
import com.example.medial.user.models.Usuario;
import com.example.medial.user.repositories.PasswordRepository;
import com.example.medial.user.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.Properties;
import java.util.Random;


@Service
public class EmailChangeBusiness {
    @Autowired
    UsersRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    PasswordRepository passwordRepository;

    @Autowired
    UsersRepository usersRepository;

    public boolean recoverPassword(ChangePasswordDto changePasswordDto) throws Exception {

        Usuario usuario = usersRepository.findByEmail(changePasswordDto.getEmail());
        if (usuario == null) {
            throw new Exception("No hay ningun usuario con ese email.");
        }
        this.enviarAviso(changePasswordDto.getEmail(),
                "Cambio de contraseña",
                "Has solicitado un cambio de contraseña", usuario.getId());
        return true;
    }


    private final Properties properties = new Properties();

    private String remitente = "qwqdwq";  //Para la dirección nomcuenta@gmail.com

    private String password = "qwdqwd";

    private Session session;

    private void init() {

        properties.put("mail.smtp.host", "smtp.gmail.com");//El servidor SMTP de Google
        properties.put("mail.smtp.starttls.enable", "true");//Para conectar de manera segura al servidor SMTP
        properties.put("mail.smtp.port", 587);//El puerto SMTP seguro de Google
        properties.put("mail.smtp.mail.sender", remitente);
        properties.put("mail.smtp.user", remitente);
        properties.put("mail.smtp.auth", "true");//Usar autenticación mediante usuario y clave
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        session = Session.getDefaultInstance(properties);
    }

    @Transactional
    public void enviarAviso(String correoDestino, String asunto, String mensaje, Long usuario) {
        this.init();


        mensaje = String.valueOf(new Random().nextInt(999999));

        // Guardo password
        Password password = passwordRepository.findPasswordByUserId(usuario);
        passwordRepository.addPasswordCode(mensaje, usuario);


        // Sender's email ID needs to be mentioned
        String correo = "@gmail.com";

        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com";

        String contra = "";


        // Get system properties
        Properties properties = new Properties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp,starttls.enable", "true");
        properties.setProperty("mail.smtp.user", correo);
        properties.setProperty("mail.smtp.port", "587");
        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(correo));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));

            // Set Subject: header field
            message.setSubject(asunto);

            // Now set the actual message
            message.setText(mensaje);

            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(correo, contra);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public boolean checkCode(ChangePasswordCodeDto changePasswordCodeDto) throws Exception {
        Usuario usuario = usersRepository.findByEmail(changePasswordCodeDto.getEmail());
        if(usuario==null){
            throw new Exception("El email no existe");
        }

        Password password= passwordRepository.findPasswordByUserId(usuario.getId());
        if(password.getPasswordRecoveryCode().equals(changePasswordCodeDto.getCode())){
            passwordRepository.updatePassword(changePasswordCodeDto.getNewPassword(),usuario.getId());
        }
        return true;
    }
}

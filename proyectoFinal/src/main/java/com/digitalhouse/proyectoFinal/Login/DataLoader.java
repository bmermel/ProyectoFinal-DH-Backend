package com.digitalhouse.proyectoFinal.Login;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password1");
        String password2 = passwordEncoder.encode("password2");
        String password3 = passwordEncoder.encode("password3");

        userRepository.save(new AppUser("Brian","bmermel","bmermel@gmail.com",password,AppUsuarioRoles.ADMIN));
        userRepository.save(new AppUser("Fernando","fconil","fconil@gmail.com",password2,AppUsuarioRoles.ADMIN));
        userRepository.save(new AppUser("Profesor","profe","profe@gmail.com",password3,AppUsuarioRoles.USER));
    }
}

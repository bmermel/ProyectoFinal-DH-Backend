package com.digitalhouse.proyectoFinal.Auth;

import com.digitalhouse.proyectoFinal.Controller.PacienteController;
import com.digitalhouse.proyectoFinal.Jwt.JwtService;
import com.digitalhouse.proyectoFinal.User.Role;
import com.digitalhouse.proyectoFinal.User.User;
import com.digitalhouse.proyectoFinal.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user=userRepository.findByUsuario(request.getUsername()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }
    public AuthResponse register(RegisterRequest request){
        User user = User.builder()
                .usuario(request.getUsuario())

                .contrasena(passwordEncoder.encode(request.getContrasena()))
                .email((request.getEmail()))
                .role(Role.valueOf(request.getRole()))
                .build();
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}

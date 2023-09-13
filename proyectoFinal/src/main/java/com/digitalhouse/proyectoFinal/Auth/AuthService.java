package com.digitalhouse.proyectoFinal.Auth;

import com.digitalhouse.proyectoFinal.Controller.PacienteController;
import com.digitalhouse.proyectoFinal.Jwt.JwtService;
import com.digitalhouse.proyectoFinal.User.Role;
import com.digitalhouse.proyectoFinal.User.User;
import com.digitalhouse.proyectoFinal.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getContrasena()));
        UserDetails usuario = userRepository.findByUsuario(request.getUsuario()).orElseThrow();
        String token = jwtService.getToken(usuario);
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

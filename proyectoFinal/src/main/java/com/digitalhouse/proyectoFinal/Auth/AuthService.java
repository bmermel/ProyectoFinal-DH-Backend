package com.digitalhouse.proyectoFinal.Auth;

import com.digitalhouse.proyectoFinal.Jwt.JwtService;
import com.digitalhouse.proyectoFinal.User.Role;
import com.digitalhouse.proyectoFinal.User.User;
import com.digitalhouse.proyectoFinal.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    public AuthResponse login(LoginRequest request){
        return null;
    }
    public AuthResponse register(RegisterRequest request){
        User user = User.builder()
                .usuario(request.getUsername())
                .contrasena((request.getPassword()))
                .email((request.getEmail()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}

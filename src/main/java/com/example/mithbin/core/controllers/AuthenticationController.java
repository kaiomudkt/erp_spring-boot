package com.example.mithbin.core.controllers;

import com.example.mithbin.core.dtos.AuthenticationDto;
import com.example.mithbin.core.dtos.RegisterDto;
import com.example.mithbin.core.enums.PermissionEnum;
import com.example.mithbin.core.models.UserModel;
import com.example.mithbin.core.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(
            @RequestBody
            @Valid
            AuthenticationDto data
    ) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                data.login(),
                data.password()
        );
        try {
            var auth = this.authenticationManager.authenticate(usernamePassword);
            // Você pode adicionar lógica adicional aqui após a autenticação bem-sucedida, se necessário.
            return ResponseEntity.ok().build();
        } catch (AuthenticationException e) {
            // Trate o caso de autenticação falha
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @PostMapping("/register")
    public ResponseEntity login(
            @RequestBody
            @Valid
            RegisterDto data
    ) {
        if (this.userRepository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        List<PermissionEnum> permissions = new ArrayList<>();
        for (String permission : data.permissions()) {
            permissions.add(PermissionEnum.toEnum(permission));
        }
        UserModel newUser = new UserModel(data.login(), encryptedPassword, permissions );
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}

package com.yasithsandesh.magulahoyamuapi.controller;


import com.yasithsandesh.magulahoyamuapi.dto.request.CreateAccountDTO;
import com.yasithsandesh.magulahoyamuapi.dto.request.LoginDTO;
import com.yasithsandesh.magulahoyamuapi.dto.response.ResponseDTO;
import com.yasithsandesh.magulahoyamuapi.service.UserService;
import com.yasithsandesh.magulahoyamuapi.util.JWTUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public  ResponseEntity<ResponseDTO> register(@Valid @RequestBody CreateAccountDTO createAccountDTO){
        return ResponseEntity.ok(userService.createAccount(createAccountDTO));
    }

    @PostMapping
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()
                )
        );


        if(authentication.isAuthenticated()){
            return ResponseEntity.ok(jwtUtil.generateToken(loginDTO.getEmail()));
        }
        return ResponseEntity.ok("Invalid email or password");
    }
}

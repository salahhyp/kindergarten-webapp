package com.daaw.project.Controllers;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daaw.project.dto.AuthResponseDto;
import com.daaw.project.dto.LoginDto;
import com.daaw.project.dto.RegisterDto;

import com.daaw.project.model.*;
import com.daaw.project.SecurityConfig.JWTGenerator;
import com.daaw.project.repositories.roleRepository;
import com.daaw.project.repositories.userRepository;

@CrossOrigin(origins="http://localhost:3000")


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private userRepository userRepository;
    private roleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, userRepository userRepository,
                          roleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        System.out.println("Login attempt reached");
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        System.out.println("User " + loginDto.getUsername() + " logged on.");
        return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);

    }


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        System.out.println("register attempt reached");
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }
        user user = new user();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        List <role> roles = new ArrayList<> ();
        for (String sRole : registerDto.getRoles()) {
            System.out.println(sRole);
            roles.add(roleRepository.findByName(sRole).get());
        }

        user.setRoles(roles);
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }}
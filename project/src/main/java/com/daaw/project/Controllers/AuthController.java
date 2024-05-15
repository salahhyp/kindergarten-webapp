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
import com.daaw.project.repositories.accountantRepository;
import com.daaw.project.repositories.adminRepository;
import com.daaw.project.repositories.educatorRepository;
import com.daaw.project.repositories.parentRepository;
import com.daaw.project.repositories.roleRepository;
import com.daaw.project.repositories.userRepository;

@CrossOrigin(origins="http://localhost:3000")


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private userRepository userRepository;
    private roleRepository roleRepository;
    private adminRepository adminRepository;
    private accountantRepository accountantRepository;
    private educatorRepository educatorRepository;

    private parentRepository parentRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, userRepository userRepository,
    roleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator,
    parentRepository parentRepository, educatorRepository educatorRepository,
    accountantRepository accountantRepository, adminRepository adminRepository) {

        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.parentRepository = parentRepository;
        this.educatorRepository = educatorRepository;
        this.accountantRepository = accountantRepository;
        this.adminRepository = adminRepository;
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
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        System.out.println("register attempt reached for "+registerDto.getUsername());
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }
    
        user user = new user();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
    
        List<role> roles = new ArrayList<>();
        for (String sRole : registerDto.getRoles()) {
            System.out.println(sRole);
            roles.add(roleRepository.findByName(sRole).get());
        }
    
        user.setRoles(roles);
        userRepository.save(user);
    
        // Create and link role-specific entities
        createRoleSpecificEntities(user, roles);
    
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
    
    private void createRoleSpecificEntities(user user, List<role> roles) {
        for (role role : roles) {
            String roleName = role.getName().toUpperCase();
            switch (roleName) {
                case "PARENT":
                    createParentEntity(user);
                    break;
                case "EDUCATOR":
                    createEducatorEntity(user);
                    break;
                case "ACCOUNTANT":
                    createAccountantEntity(user);
                    break;
                case "ADMIN":
                    createAdminEntity(user);
                    break;
                // Add more cases for other roles as needed
                default:
                    break;
            }
        }
    }
    
    private void createParentEntity(user user) {
        parent parent = new parent();
        parent.setUser(user);
        // Set other properties of the parent entity as needed
        parentRepository.save(parent);
    }
    private void createEducatorEntity(user user) {
        educator educator = new educator();
        educator.setUser(user);
        // Set other properties of the educator entity as needed
        educatorRepository.save(educator);
    }
    
    private void createAccountantEntity(user user) {
        accountant accountant = new accountant();
        accountant.setUser(user);
        // Set other properties of the accountant entity as needed
        accountantRepository.save(accountant);
    }
    
    private void createAdminEntity(user user) {
        admin admin = new admin();
        admin.setUser(user);
        // Set other properties of the admin entity as needed
        adminRepository.save(admin);
    }
    

}
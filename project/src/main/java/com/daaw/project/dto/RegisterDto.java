package com.daaw.project.dto;

import java.util.List;

import com.daaw.project.model.role;
import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private List <String> roles;



}
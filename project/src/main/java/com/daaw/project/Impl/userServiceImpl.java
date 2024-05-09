package com.daaw.project.Impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.daaw.project.model.user;
import com.daaw.project.repositories.userRepository;

import com.daaw.project.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class userServiceImpl implements userService {


}

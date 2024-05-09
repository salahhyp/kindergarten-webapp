package com.daaw.project.services;

import com.daaw.project.model.visitor;

import java.util.List;

public interface visitorService {


    visitor findById(Long id);
    List<visitor> findAll();
    visitor save(visitor visitor);
}

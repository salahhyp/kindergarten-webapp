package com.daaw.project.services;


import com.daaw.project.model.preinscrit;

import java.util.List;


public interface preinscritService {

    preinscrit findById(Long id);

    preinscrit addpreinscrit(preinscrit preinscrit);
    List<preinscrit> findAll();
    preinscrit save(preinscrit preinscrit);
    void deleteById(Long id);



}

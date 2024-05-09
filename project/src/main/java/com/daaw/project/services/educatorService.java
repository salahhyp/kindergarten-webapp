package com.daaw.project.services;


import com.daaw.project.model.educator;

import java.util.List;
import java.util.Optional;

public interface educatorService {
    educator findById(Long id);
    List<educator> findAll();
    educator save(educator educator);
    void deleteById(Long id);

    Optional<educator> geteducatorById(Long id);

    List<educator> getAlleducators();

    educator addeducator(educator educator);
}

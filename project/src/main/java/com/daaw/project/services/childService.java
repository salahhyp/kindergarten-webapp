package com.daaw.project.services;

import com.daaw.project.model.child;

import java.util.List;
import java.util.Optional;

public interface childService {
    child findById(Long id);
    List<child> findAll();
    child save(child parent);
    void deletechildById(Long id);

    child addchild(child child);

    List<child> getAllchildren();

    Optional<child> getchildById(Long id);
}

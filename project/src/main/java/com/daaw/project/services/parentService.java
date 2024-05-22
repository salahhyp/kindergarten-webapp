package com.daaw.project.services;



import com.daaw.project.model.parent;
import com.daaw.project.model.user;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface parentService {

    public parent addparent(parent mparent);

    public parent getparent(Long id);
    public void deleteparent(Long id);

    public Page<parent> getAllparents(Pageable pageable);

    parent getParentById(Long parentId);

    public parent findByUser(Optional<user> user);

    public parent save(parent parent);

    public Optional<parent> findById(Long id);

    public parent findByUser(user user);
}


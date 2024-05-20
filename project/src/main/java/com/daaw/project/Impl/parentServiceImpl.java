package com.daaw.project.Impl;

import com.daaw.project.model.parent;
import com.daaw.project.model.user;
import com.daaw.project.repositories.parentRepository;
import com.daaw.project.services.parentService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class parentServiceImpl implements parentService {

    @Autowired
    parentRepository parentRepository;

    @Override
    public parent addparent(parent mparent) {
        return parentRepository.save(mparent);
    }

    @Override
    public parent getparent(Long id) {
        return parentRepository.findById(id).get();
    }

    @Override
    public void deleteparent(Long id) {
        parentRepository.deleteById(id);
    }

    @Override
    public Page<parent> getAllparents(Pageable pageable) {
        return parentRepository.findAll(pageable);
    }


    @Override
    public parent getParentById(Long parentId) {
        return parentRepository.findById(parentId).orElse(null);
    }

    @Override
    public parent findByUser(Optional<user> user) {

        return parentRepository.findByUser(user);
    }

    @Override
    public parent save(parent parent) {

        return parentRepository.save(parent);
    }

    @Override
    public Optional<parent> findById(Long id) {

        return parentRepository.findById(id);
    }



}

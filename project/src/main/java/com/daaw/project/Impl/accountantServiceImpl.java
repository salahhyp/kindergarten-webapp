package com.daaw.project.Impl;

import com.daaw.project.model.accountant;
import com.daaw.project.repositories.accountantRepository;
import com.daaw.project.services.accountantService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class accountantServiceImpl implements accountantService {

    @Autowired
    private accountantRepository accountantRepository;
    @Override
    public accountant findById(Long id) {
        Optional<accountant> accountant = accountantRepository.findById(id);
        return accountant.orElse(null);
    }

    @Override
    public List<accountant> findAll() {
        return accountantRepository.findAll();
    }

    @Override
    public accountant save(accountant accountant) {
        return accountantRepository.save(accountant);
    }

    @Override
    public void deleteById(Long id) {
        accountantRepository.deleteById(id);
    }


    @Override
    public accountant addaccountant(accountant accountant) {
        return accountantRepository.save(accountant);
    }
    @Override
    public Optional<accountant> getaccountantById(Long id) {
        return accountantRepository.findById(id);

    }

    @Override
    public List<accountant> getAllAccountants() {
        return accountantRepository.findAll();
    }


}
package com.daaw.project.services;


import com.daaw.project.model.accountant;

import java.util.List;
import java.util.Optional;

public interface accountantService {

    accountant findById(Long id);
    List<accountant> findAll();
    accountant save(accountant accountant);
    void deleteById(Long id);
    Optional<accountant> getaccountantById(Long id);
    List<accountant> getAllAccountants();
    accountant addaccountant(accountant accountant);
}

package com.daaw.project.services;


import com.daaw.project.model.payment;

import java.util.List;
import java.util.Optional;

public interface paymentService {
    payment findById(Long id);
    List<payment> findAll();
    payment save(payment payment);
    void deleteById(Long id);

    Optional<payment> getpaymentById(Long id);

    List<payment> getAllpayments();

    payment addpayment(payment payment);
}

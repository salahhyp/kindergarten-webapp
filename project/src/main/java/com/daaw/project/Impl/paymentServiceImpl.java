package com.daaw.project.Impl;



import com.daaw.project.model.payment;
import com.daaw.project.repositories.paymentRepository;
import com.daaw.project.services.paymentService;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class paymentServiceImpl implements paymentService {

    @Autowired
    private paymentRepository paymentRepository;

    @Override
    public payment findById(Long id) {
        Optional<payment> payment = paymentRepository.findById(id);
        return payment.orElse(null);
    }

    @Override
    public List<payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public payment save(payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public payment addpayment(payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<payment> getAllpayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<payment> getpaymentById(Long id) {
        return paymentRepository.findById(id);
    }

}

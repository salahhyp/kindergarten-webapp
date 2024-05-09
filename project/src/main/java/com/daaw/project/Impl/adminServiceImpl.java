package com.daaw.project.Impl;


import com.daaw.project.model.admin;
import com.daaw.project.repositories.adminRepository;
import com.daaw.project.services.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class adminServiceImpl implements adminService{


    @Autowired
    private adminRepository adminRepository;

    @Override
    public admin findById(Long id) {
        Optional<admin> admin = adminRepository.findById(id);
        return admin.orElse(null);
    }

    @Override
    public List<admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public admin save(admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

}

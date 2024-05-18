package com.daaw.project.services;


import com.daaw.project.model.admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface adminService {

    admin findById(Long id);
    List<admin> findAll();
    admin save(admin admin);
    void deleteById(Long id);

    admin getAdminById(Long adminId);
}

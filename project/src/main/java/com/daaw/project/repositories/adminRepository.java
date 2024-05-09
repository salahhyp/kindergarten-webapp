package com.daaw.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.daaw.project.model.admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface adminRepository extends JpaRepository<admin,Long> {

}

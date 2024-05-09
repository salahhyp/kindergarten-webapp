package com.daaw.project.repositories;

import com.daaw.project.model.accountant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface accountantRepository extends JpaRepository<accountant,Long> {
}

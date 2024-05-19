package com.daaw.project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.daaw.project.model.parent;
import com.daaw.project.model.user;

import org.springframework.stereotype.Repository;


@Repository
public interface parentRepository extends JpaRepository<parent,Long> {

    parent findByUser(Optional<user> user);
}

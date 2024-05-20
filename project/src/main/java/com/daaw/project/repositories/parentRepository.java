package com.daaw.project.repositories;

import com.daaw.project.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import com.daaw.project.model.parent;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface parentRepository extends JpaRepository<parent,Long> {

    parent findByUser(Optional<user> user);
}

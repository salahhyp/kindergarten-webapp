package com.daaw.project.repositories;

import com.daaw.project.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface userRepository extends JpaRepository<user,Long>{
    Optional<user> findByUsername(String username);
    Boolean existsByUsername(String username);
}

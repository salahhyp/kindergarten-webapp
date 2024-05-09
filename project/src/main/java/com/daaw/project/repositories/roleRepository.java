package com.daaw.project.repositories;
import java.util.Optional;
import com.daaw.project.model.role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roleRepository extends JpaRepository<role, Integer>{

    Optional<role> findByName(String name);

}

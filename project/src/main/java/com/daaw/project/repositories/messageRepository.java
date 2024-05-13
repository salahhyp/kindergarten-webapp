package com.daaw.project.repositories;
import com.daaw.project.model.message;
import com.daaw.project.model.parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface messageRepository extends JpaRepository<message,Long> {





}

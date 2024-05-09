package com.daaw.project.repositories;



import com.daaw.project.model.event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface eventRepository extends JpaRepository <event,Long>{


}

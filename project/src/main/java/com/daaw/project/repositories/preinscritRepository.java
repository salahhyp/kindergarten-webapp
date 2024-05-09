package com.daaw.project.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.daaw.project.model.preinscrit;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface preinscritRepository extends JpaRepository<preinscrit,Long> {

}

package com.daaw.project.repositories;
import com.daaw.project.model.visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import com.daaw.project.model.session;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface sessionRepository extends JpaRepository<session,Long>{

}

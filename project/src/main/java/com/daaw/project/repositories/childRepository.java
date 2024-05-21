package com.daaw.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.daaw.project.model.child;
import org.springframework.stereotype.Repository;


@Repository
public interface childRepository extends JpaRepository<child,Long> {
    List<child> getChildrenByGroupId(Long groupId);

}

package com.daaw.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.daaw.project.model.child;
import com.daaw.project.model.parent;
import com.daaw.project.model.user;

import org.springframework.stereotype.Repository;


@Repository
public interface childRepository extends JpaRepository<child,Long> {
    List<child> getChildrenByGroupId(Long groupId);

    child getChildByParentId(Long parentId);


    child findByParent(parent parent);

}

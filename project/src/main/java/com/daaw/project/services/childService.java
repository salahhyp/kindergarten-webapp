package com.daaw.project.services;

import com.daaw.project.model.child;
import com.daaw.project.model.parent;
import com.daaw.project.model.user;

import java.util.List;
import java.util.Optional;

public interface childService {
    child findById(Long id);
    List<child> findAll();
    child save(child parent);
    void deletechildById(Long id);

    child addchild(child child);

    List<child> getAllchildren();

    Optional<child> getchildById(Long id);
    List<child> getChildrenByGroupId(Long groupId);
    child getChildByParentId(Long parentId);
    child findByParent(parent byUser);

}

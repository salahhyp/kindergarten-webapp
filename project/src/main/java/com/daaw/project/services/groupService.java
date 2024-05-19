package com.daaw.project.services;

import com.daaw.project.model.group;
import com.daaw.project.model.group.Plan;
import com.daaw.project.model.group.Schedule;

import java.util.List;
import java.util.Optional;

public interface groupService {
    group createGroup(group group);
    group getGroupById(Long id);
    void deleteGroupById(Long id);
    List<group> getAllGroups();
    List<group> findAvailableGroups(Plan plan, Schedule schedule);
    Optional<group> findById(Long groupId);
}
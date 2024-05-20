package com.daaw.project.Impl;

import com.daaw.project.model.group;
import com.daaw.project.model.group.Plan;
import com.daaw.project.model.group.Schedule;
import com.daaw.project.services.groupService;

import jakarta.annotation.PostConstruct;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class groupServiceImpl implements groupService {

    @Autowired
    private com.daaw.project.repositories.groupRepository groupRepository;

    // @PostConstruct
    // private void initializeBaseGroups() {
    //     // Create 6 base groups with different plans and schedules
    //     group group1 = new group("TODDLER", "HALF_DAY");
    //     group group2 = new group("TODDLER", "FULL_DAY" );
    //     group group3 = new group("PRESCHOOL", "HALF_DAY" );
    //     group group4 = new group("PRESCHOOL", "FULL_DAY" );
    //     group group5 = new group("KINDERGARTEN", "HALF_DAY" );
    //     group group6 = new group("KINDERGARTEN", "FULL_DAY");

    //     groupRepository.saveAll(Arrays.asList(group1, group2, group3, group4, group5, group6));
    // }

    @Override
    public group createGroup(group group) {
        return groupRepository.save(group);
    }

    @Override
    public group getGroupById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);
    }



    @Override
    public List<group> findAvailableGroups(Plan plan, Schedule schedule) {
        return groupRepository.findByPlanAndSchedule(plan, schedule);
    }

    @Override
    public List<group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<group> findById(Long groupId) {

        return groupRepository.findById(groupId);
    }


}
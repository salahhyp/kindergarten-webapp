package com.daaw.project.repositories;



import com.daaw.project.model.group;
import com.daaw.project.model.group.Plan;
import com.daaw.project.model.group.Schedule;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface groupRepository extends JpaRepository <group,Long>{

    List<group> findByPlanAndSchedule(Plan plan, Schedule schedule);
    Optional<group> findById(Long groupId);


}

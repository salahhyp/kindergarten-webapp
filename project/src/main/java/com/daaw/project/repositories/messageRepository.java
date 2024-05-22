package com.daaw.project.repositories;
import com.daaw.project.model.message;
import com.daaw.project.model.parent;
import com.daaw.project.dto.MessageDto;
import com.daaw.project.model.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface messageRepository extends JpaRepository<message,Long> {

    List<message> findByParentId(Long parentId);
    List<message> findByAdminId(Long adminId);
    List<message> findAllByAdminIdAndParentId(Long adminId, Long parentId);



}

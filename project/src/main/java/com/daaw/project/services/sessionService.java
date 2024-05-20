package com.daaw.project.services;
import com.daaw.project.model.session;

import java.util.List;
public interface sessionService {
    session findById(Long id);
    List<session> findAll();
    session save(session session);
    void deleteById(Long id);
    List<session> findAllByGroupId(Long groupId);
    List<session> findAllByEducatorId(Long educatorId);


}

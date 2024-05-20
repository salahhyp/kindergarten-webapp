package com.daaw.project.Impl;

import com.daaw.project.model.session;
import com.daaw.project.repositories.sessionRepository;
import com.daaw.project.services.sessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class sessionServiceImpl implements sessionService {

    @Autowired
    private sessionRepository sessionRepository;

    @Override
    public session findById(Long id) {
        Optional<session> session = sessionRepository.findById(id);
        return session.orElse(null);
    }

    @Override
    public List<session> findAll() {
        return sessionRepository.findAll();
    }

    @Override
    public session save(session session) {
        return sessionRepository.save(session);
    }

    @Override
    public void deleteById(Long id) {
        sessionRepository.deleteById(id);
    }

    @Override
    public List<session> findAllByGroupId(Long groupId) {

        return sessionRepository.findAllByGroupId(groupId);
    }

    @Override
    public List<session> findAllByEducatorId(Long educatorId) {
        return sessionRepository.findAllByEducatorId(educatorId);
    }



}

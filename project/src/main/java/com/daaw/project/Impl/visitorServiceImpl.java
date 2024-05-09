package com.daaw.project.Impl;

import com.daaw.project.model.visitor;
import com.daaw.project.repositories.visitorRepository;
import com.daaw.project.services.visitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class visitorServiceImpl implements visitorService {

    @Autowired
    private visitorRepository visitorRepository;
    @Override
    public visitor findById(Long id) {
        Optional<visitor> visitor = visitorRepository.findById(id);
        return visitor.orElse(null);
    }
    @Override
    public List<visitor> findAll() {
        return visitorRepository.findAll();
    }
    @Override
    public visitor save(visitor visitor) {
        return visitorRepository.save(visitor);
    }


}

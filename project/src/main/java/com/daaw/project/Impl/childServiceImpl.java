package com.daaw.project.Impl;

import com.daaw.project.model.child;
import com.daaw.project.repositories.childRepository;
import com.daaw.project.services.childService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class childServiceImpl implements childService {

    @Autowired
    private childRepository childRepository;

    @Override
    public child findById(Long id) {
        Optional<child> client = childRepository.findById(id);
        return client.orElse(null);
    }

    @Override
    public List<child> findAll() {
        return childRepository.findAll();
    }

    @Override
    public child save(child child) {
        return childRepository.save(child);
    }

    @Override
    public void deletechildById(Long id) {
        childRepository.deleteById(id);
    }

    @Override
    public child addchild(child child) {
        return childRepository.save(child);
    }


    @Override
    public List<child> getAllchildren() {
        return childRepository.findAll();
    }

    public Optional<child> getchildById(Long id) {
        return childRepository.findById(id);

    }
    @Override
    public List<child> getChildrenByGroupId(Long groupId) {

        return childRepository.getChildrenByGroupId(groupId);
    }
}

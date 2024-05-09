package com.daaw.project.Impl;



import com.daaw.project.model.event;
import com.daaw.project.repositories.eventRepository;
import com.daaw.project.services.eventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class eventServiceImpl implements eventService {

    @Autowired
    private eventRepository eventRepository;

    @Override
    public event findById(Long id) {
        Optional<event> event = eventRepository.findById(id);
        return event.orElse(null);
    }

    @Override
    public List<event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public event save(event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public event addevent(event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<event> getAllevents() {
        return eventRepository.findAll();
    }

    public Optional<event> geteventById(Long id) {
        return eventRepository.findById(id);

    }

}

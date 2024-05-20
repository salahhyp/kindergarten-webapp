package com.daaw.project.services;

import com.daaw.project.dto.EventDto;
import com.daaw.project.model.event;

import java.util.List;
import java.util.Optional;

public interface eventService {
    event findById(Long id);
    List<event> findAll();
    event save(EventDto eventDto);
    void deleteById(Long id);

    Optional<event> geteventById(Long id);

    List<event> getAllevents();

    event addevent(EventDto eventDto);
}

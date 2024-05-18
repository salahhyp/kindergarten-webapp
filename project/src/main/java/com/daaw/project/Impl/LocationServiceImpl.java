package com.daaw.project.Impl;
import com.daaw.project.SecurityConfig.ApiConfig;

import com.daaw.project.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.daaw.project.model.Location;
import com.daaw.project.repositories.LocationRepository;
import com.daaw.project.model.parent;
import com.daaw.project.repositories.parentRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getLocationsByParentId(Long parentId) {
        return locationRepository.findByParentId(parentId);
    }

    @Override
    public void saveLocation(Location location) {
        locationRepository.save(location);
    }
}

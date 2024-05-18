package com.daaw.project.services;
import com.daaw.project.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    List<Location> getLocationsByParentId(Long parentId);
    void saveLocation(Location location);
}

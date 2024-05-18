package com.daaw.project.Controllers;
import com.daaw.project.model.parent;
import com.daaw.project.services.LocationService;
import com.daaw.project.services.parentService;
import com.daaw.project.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private parentService parentService;

    @GetMapping("/parent/{parentId}")
    public List<Location> getLocationsByParentId(@PathVariable Long parentId) {
        return locationService.getLocationsByParentId(parentId);
    }

    @PostMapping("/update")
    public void updateLocation(@RequestParam Long parentId, @RequestParam double latitude, @RequestParam double longitude) {
        parent parent = parentService.getParentById(parentId);
        if (parent != null) {
            Location location = new Location();
            location.setParent(parent);
            location.setLatitude(latitude);
            location.setLongitude(longitude);
            location.setTimestamp(LocalDateTime.now());
            locationService.saveLocation(location);
        }
    }
}

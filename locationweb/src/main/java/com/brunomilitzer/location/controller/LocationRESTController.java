package com.brunomilitzer.location.controller;

import com.brunomilitzer.location.entity.Location;
import com.brunomilitzer.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    @Autowired
    private LocationRepository repository;

    @GetMapping
    public List<Location> getLocations() {

        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable("id") final Long id) {

        return this.repository.findById(id).get();

    }

    @PostMapping
    public Location createLocation(@RequestBody final Location location) {

        return this.repository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody final Location location) {

        return this.repository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") final Long id) {

        this.repository.deleteById(id);
    }

}

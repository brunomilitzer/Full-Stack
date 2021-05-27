package com.brunomilitzer.location.service;


import com.brunomilitzer.location.entity.Location;
import com.brunomilitzer.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repository;

    @Override
    public Location saveLocation(final Location location) {

        return this.repository.save(location);
    }

    @Override
    public Location updateLocation(final Location location) {

        return this.repository.save(location);
    }

    @Override
    public void deleteLocation(final Location location) {

        this.repository.delete(location);
    }

    @Override
    public Location getLocationById(final Long id) {

        return this.repository.findById(id).get();
    }

    @Override
    public List<Location> getAllLocations() {

        return this.repository.findAll();
    }

    @Override
    public List<Object[]> findTypeAndTypeCount() {

        return this.repository.findTypeAndTypeCount();
    }

}

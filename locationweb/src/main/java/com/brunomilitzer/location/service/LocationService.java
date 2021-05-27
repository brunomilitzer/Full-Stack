package com.brunomilitzer.location.service;

import com.brunomilitzer.location.entity.Location;

import java.util.List;

public interface LocationService {

    Location saveLocation(Location location);

    Location updateLocation(Location location);

    void deleteLocation(Location location);

    Location getLocationById(Long id);

    List<Location> getAllLocations();

    List<Object[]> findTypeAndTypeCount();

}

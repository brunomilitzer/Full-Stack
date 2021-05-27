package com.brunomilitzer.location.repository;

import com.brunomilitzer.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query(value = "SELECT type, COUNT(type) as total FROM location GROUP BY type", nativeQuery = true)
    List<Object[]> findTypeAndTypeCount();

}

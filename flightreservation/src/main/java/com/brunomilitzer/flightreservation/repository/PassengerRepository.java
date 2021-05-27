package com.brunomilitzer.flightreservation.repository;

import com.brunomilitzer.flightreservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}

package com.brunomilitzer.flightreservation.repository;

import com.brunomilitzer.flightreservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}

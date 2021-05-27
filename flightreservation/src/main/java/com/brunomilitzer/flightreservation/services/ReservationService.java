package com.brunomilitzer.flightreservation.services;

import com.brunomilitzer.flightreservation.dto.ReservationRequest;
import com.brunomilitzer.flightreservation.entities.Reservation;

public interface ReservationService {

    Reservation bookFlight(ReservationRequest request);

    Reservation findById(Long id);

    Reservation save(Reservation reservation);

}

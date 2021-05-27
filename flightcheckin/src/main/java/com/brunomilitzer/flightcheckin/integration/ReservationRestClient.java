package com.brunomilitzer.flightcheckin.integration;

import com.brunomilitzer.flightcheckin.dto.Reservation;
import com.brunomilitzer.flightcheckin.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

    Reservation findReservation(Long id);

    Reservation updateReservation(ReservationUpdateRequest request);

}

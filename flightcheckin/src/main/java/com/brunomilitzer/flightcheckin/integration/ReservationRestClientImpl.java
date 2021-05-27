package com.brunomilitzer.flightcheckin.integration;

import com.brunomilitzer.flightcheckin.dto.Reservation;
import com.brunomilitzer.flightcheckin.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    public static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";

    @Override
    public Reservation findReservation(final Long id) {

        final RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(RESERVATION_REST_URL + id, Reservation.class);
    }

    @Override
    public Reservation updateReservation(final ReservationUpdateRequest request) {

        final RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
    }

}

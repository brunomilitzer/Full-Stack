package com.brunomilitzer.flightreservation.controllers;

import com.brunomilitzer.flightreservation.dto.ReservationUpdateRequest;
import com.brunomilitzer.flightreservation.entities.Reservation;
import com.brunomilitzer.flightreservation.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ReservationRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

    @Autowired
    private ReservationService service;

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") final Long id) {

        LOGGER.info("Inside findReservation() {}", id);

        return this.service.findById(id);
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody final ReservationUpdateRequest request) {

        LOGGER.info("Inside updateReservation()");

        final Reservation reservation = this.service.findById(request.getId());
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.isCheckedIn());

        LOGGER.info("Saving reservation {}", request);

        return this.service.save(reservation);
    }

}

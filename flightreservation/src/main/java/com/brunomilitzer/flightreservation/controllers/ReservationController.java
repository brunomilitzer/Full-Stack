package com.brunomilitzer.flightreservation.controllers;

import com.brunomilitzer.flightreservation.dto.ReservationRequest;
import com.brunomilitzer.flightreservation.entities.Flight;
import com.brunomilitzer.flightreservation.entities.Reservation;
import com.brunomilitzer.flightreservation.repository.FlightRepository;
import com.brunomilitzer.flightreservation.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    private FlightRepository repository;

    @Autowired
    private ReservationService service;

    @RequestMapping(value = "/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") final Long flightId, final ModelMap modelMap) {

        final Flight flight = this.repository.findById(flightId).get();
        modelMap.addAttribute("flight", flight);

        LOGGER.info("Inside showCompleteReservation() {}", flight);

        return "completeReservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(final ReservationRequest request, final ModelMap modelMap) {

        final Reservation reservation = this.service.bookFlight(request);
        modelMap.addAttribute("msg", "Reservation created successfully and the id is " + reservation.getId());

        LOGGER.info("Inside completeReservation() {}", request);

        return "reservationConfirmation";
    }

}

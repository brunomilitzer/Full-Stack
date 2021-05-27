package com.brunomilitzer.flightreservation.controllers;

import com.brunomilitzer.flightreservation.entities.Flight;
import com.brunomilitzer.flightreservation.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightsController.class);

    @Autowired
    private FlightRepository repository;

    @RequestMapping(value = "/findFlights")
    public String findFlights(@RequestParam("from") final String from,
                              @RequestParam("to") final String to,
                              @RequestParam("departureDate")
                              @DateTimeFormat(pattern = "dd/MM/yyyy") final Date departureDate,
                              final ModelMap modelMap) {

        final List<Flight> flights = this.repository.findFlights(from, to, departureDate);
        modelMap.addAttribute("flights", flights);

        LOGGER.info("Finding flights from {} to {} departureDate {}", from, to, departureDate);

        return "displayFlights";

    }

    @RequestMapping("admin/showAddFlight")
    public String showAddFlight() {

        return "addFlight";
    }

}

package com.brunomilitzer.flightcheckin.controllers;

import com.brunomilitzer.flightcheckin.dto.Reservation;
import com.brunomilitzer.flightcheckin.dto.ReservationUpdateRequest;
import com.brunomilitzer.flightcheckin.integration.ReservationRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    private ReservationRestClient restClient;

    @RequestMapping("/showStartCheckin")
    public String showStartCheckin() {

        return "startCheckin";
    }

    @RequestMapping("/startCheckIn")
    public String startCheckIn(@RequestParam("reservationId") final Long reservationId, final ModelMap modelMap) {

        final Reservation reservation = this.restClient.findReservation(reservationId);
        modelMap.addAttribute("reservation", reservation);

        return "displayReservationDetails";
    }

    @RequestMapping(value = "/completeCheckIn", method = RequestMethod.POST)
    public String completeCheckIn(@RequestParam("reservationId") final Long reservationId, @RequestParam("numberOfBags") final Integer numberOfBags) {

        final ReservationUpdateRequest request = new ReservationUpdateRequest();
        request.setId(reservationId);
        request.setCheckedIn(true);
        request.setNumberOfBags(numberOfBags);

        final Reservation reservation = this.restClient.updateReservation(request);

        return "checkinConfirmation";
    }

}

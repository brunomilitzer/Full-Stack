package com.brunomilitzer.flightreservation;

import com.brunomilitzer.flightreservation.dto.ReservationRequest;
import com.brunomilitzer.flightreservation.dto.ReservationUpdateRequest;
import com.brunomilitzer.flightreservation.entities.Flight;
import com.brunomilitzer.flightreservation.entities.Passenger;
import com.brunomilitzer.flightreservation.entities.Reservation;
import com.brunomilitzer.flightreservation.repos.FlightRepository;
import com.brunomilitzer.flightreservation.repos.PassengerRepository;
import com.brunomilitzer.flightreservation.repos.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReservationRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") final Long id) {

        LOGGER.info("Inside findReservation() for id: " + id);
        return this.reservationRepository.findById(id).get();

    }

    @RequestMapping(value = "/flights", method = RequestMethod.GET)
    public List<Flight> findFlights() {

        return this.flightRepository.findAll();

    }

    @RequestMapping(value = "/reservations", method = RequestMethod.POST)
    @Transactional
    public Reservation saveReservation(@RequestBody final ReservationRequest request) {

        LOGGER.info("Inside bookFlight()");
        // Make Payment

        final Long flightId = request.getFlightId();
        LOGGER.info("Fetching  flight for flight id:" + flightId);
        final Flight flight = this.flightRepository.findById(flightId).get();

        final Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());
        LOGGER.info("Saving the passenger:" + passenger);
        final Passenger savedPassenger = this.passengerRepository.save(passenger);

        final Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        LOGGER.info("Saving the reservation:" + reservation);
        final Reservation savedReservation = this.reservationRepository.save(reservation);


        return savedReservation;

    }


    @RequestMapping(value = "/reservations", method = RequestMethod.PUT)
    public Reservation updateReservation(@RequestBody final ReservationUpdateRequest request) {

        LOGGER.info("Inside updateReservation() for " + request);
        System.out.println("Inside updateReservation() for " + request);
        final Reservation reservation = this.reservationRepository.findById(request.getId()).get();
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckedIn());
        LOGGER.info("Saving Reservation");
        return this.reservationRepository.save(reservation);

    }

}

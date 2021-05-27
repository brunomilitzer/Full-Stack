package com.brunomilitzer.flightreservation.services;

import com.brunomilitzer.flightreservation.dto.ReservationRequest;
import com.brunomilitzer.flightreservation.entities.Flight;
import com.brunomilitzer.flightreservation.entities.Passenger;
import com.brunomilitzer.flightreservation.entities.Reservation;
import com.brunomilitzer.flightreservation.repository.FlightRepository;
import com.brunomilitzer.flightreservation.repository.PassengerRepository;
import com.brunomilitzer.flightreservation.repository.ReservationRepository;
import com.brunomilitzer.flightreservation.util.EmailUtil;
import com.brunomilitzer.flightreservation.util.PDFGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Value("${com.brunomilitzer.flightreservation.itinerary.dirpath}")
    public String ITINERARY_DIR;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    PDFGenerator generator;

    @Autowired
    EmailUtil emailUtil;

    @Override
    @Transactional
    public Reservation bookFlight(final ReservationRequest request) {

        // Make payment
        LOGGER.info("Inside bookFlight()");

        final Long flightId = request.getFlightId();

        LOGGER.info("Fetching flight for flight id: {}", flightId);

        final Flight flight = this.flightRepository.findById(flightId).get();

        final Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());

        LOGGER.info("Saving the passenger: {}", passenger);

        final Passenger savedPassenger = this.passengerRepository.save(passenger);

        final Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        LOGGER.info("Saving the reservation: {}", reservation);

        final Reservation savedReservation = this.reservationRepository.save(reservation);

        final String filePath = this.ITINERARY_DIR + savedReservation.getId() + ".pdf";

        LOGGER.info("Generating the Itinerary");

        this.generator.generateItinerary(savedReservation,
                filePath);

        LOGGER.info("Sending the Itinerary");
        this.emailUtil.sendItinerary(passenger.getEmail(), filePath);

        return savedReservation;
    }

    @Override
    public Reservation findById(final Long id) {

        return this.reservationRepository.findById(id).get();
    }

    @Override
    public Reservation save(final Reservation reservation) {

        return this.reservationRepository.save(reservation);
    }

}

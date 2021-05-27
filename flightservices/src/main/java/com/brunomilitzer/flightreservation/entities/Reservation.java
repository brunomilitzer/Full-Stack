package com.brunomilitzer.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity {

    private Boolean checkedIn;

    private int numberOfBags;

    @OneToOne
    private Passenger passenger;

    @OneToOne
    private Flight flight;

    public Boolean getCheckedIn() {

        return this.checkedIn;
    }

    public void setCheckedIn(final Boolean checkedIn) {

        this.checkedIn = checkedIn;
    }

    public int getNumberOfBags() {

        return this.numberOfBags;
    }

    public void setNumberOfBags(final int numberOfBags) {

        this.numberOfBags = numberOfBags;
    }

    public Passenger getPassenger() {

        return this.passenger;
    }

    public void setPassenger(final Passenger passenger) {

        this.passenger = passenger;
    }

    public Flight getFlight() {

        return this.flight;
    }

    public void setFlight(final Flight flight) {

        this.flight = flight;
    }

}

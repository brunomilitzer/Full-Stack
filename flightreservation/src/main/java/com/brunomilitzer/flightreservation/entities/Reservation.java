package com.brunomilitzer.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity {

    private static final long serialVersionUID = -7886575740761734544L;

    private Boolean checkedIn;

    private Integer numberOfBags;

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

    public Integer getNumberOfBags() {

        return this.numberOfBags;
    }

    public void setNumberOfBags(final Integer numberOfBags) {

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

    @Override
    public String toString() {

        return "Reservation{" +
                "checkedIn=" + this.checkedIn +
                ", numberOfBags=" + this.numberOfBags +
                ", passenger=" + this.passenger +
                ", flight=" + this.flight +
                '}';
    }

}

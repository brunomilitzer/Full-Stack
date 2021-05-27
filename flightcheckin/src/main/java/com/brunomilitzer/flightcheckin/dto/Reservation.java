package com.brunomilitzer.flightcheckin.dto;

import java.io.Serializable;

public class Reservation implements Serializable {

    private static final long serialVersionUID = -7886575740761734544L;

    private Long id;

    private Boolean checkedIn;

    private Integer numberOfBags;

    private Passenger passenger;

    private Flight flight;

    public Long getId() {

        return this.id;
    }

    public void setId(final Long id) {

        this.id = id;
    }

    public static long getSerialVersionUID() {

        return serialVersionUID;
    }

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

}

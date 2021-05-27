package com.brunomilitzer.flightreservation.dto;

public class ReservationUpdateRequest {

    private Long id;

    private Boolean checkedIn;

    private int numberOfBags;

    public Long getId() {

        return this.id;
    }

    public void setId(final Long id) {

        this.id = id;
    }

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

}

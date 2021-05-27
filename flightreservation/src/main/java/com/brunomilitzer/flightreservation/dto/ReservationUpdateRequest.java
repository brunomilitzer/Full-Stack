package com.brunomilitzer.flightreservation.dto;

public class ReservationUpdateRequest {

    private Long id;

    private boolean checkedIn;

    private Integer numberOfBags;

    public Long getId() {

        return this.id;
    }

    public void setId(final Long id) {

        this.id = id;
    }

    public boolean isCheckedIn() {

        return this.checkedIn;
    }

    public void setCheckedIn(final boolean checkedIn) {

        this.checkedIn = checkedIn;
    }

    public Integer getNumberOfBags() {

        return this.numberOfBags;
    }

    public void setNumberOfBags(final Integer numberOfBags) {

        this.numberOfBags = numberOfBags;
    }

    @Override
    public String toString() {

        return "ReservationUpdateRequest{" +
                "id=" + this.id +
                ", checkedIn=" + this.checkedIn +
                ", numberOfBags=" + this.numberOfBags +
                '}';
    }

}

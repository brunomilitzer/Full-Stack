package com.brunomilitzer.flightcheckin.dto;

import java.io.Serializable;

public class ReservationUpdateRequest implements Serializable {

    private static final long serialVersionUID = 8873404134015181955L;

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

}

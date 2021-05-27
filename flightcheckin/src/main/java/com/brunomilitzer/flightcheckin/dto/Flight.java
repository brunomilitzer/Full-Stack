package com.brunomilitzer.flightcheckin.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Flight implements Serializable {

    private static final long serialVersionUID = 2341840505611633499L;

    private Long id;

    private String flightNumber;

    private String operatingAirlines;

    private String departureCity;

    private String arrivalCity;

    private Date dateOfDeparture;

    private Timestamp estimatedDepartureTime;

    public Long getId() {

        return this.id;
    }

    public void setId(final Long id) {

        this.id = id;
    }

    public String getFlightNumber() {

        return this.flightNumber;
    }

    public void setFlightNumber(final String flightNumber) {

        this.flightNumber = flightNumber;
    }

    public String getOperatingAirlines() {

        return this.operatingAirlines;
    }

    public void setOperatingAirlines(final String operatingAirlines) {

        this.operatingAirlines = operatingAirlines;
    }

    public String getDepartureCity() {

        return this.departureCity;
    }

    public void setDepartureCity(final String departureCity) {

        this.departureCity = departureCity;
    }

    public String getArrivalCity() {

        return this.arrivalCity;
    }

    public void setArrivalCity(final String arrivalCity) {

        this.arrivalCity = arrivalCity;
    }

    public Date getDateOfDeparture() {

        return this.dateOfDeparture;
    }

    public void setDateOfDeparture(final Date dateOfDeparture) {

        this.dateOfDeparture = dateOfDeparture;
    }

    public Timestamp getEstimatedDepartureTime() {

        return this.estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(final Timestamp estimatedDepartureTime) {

        this.estimatedDepartureTime = estimatedDepartureTime;
    }

}

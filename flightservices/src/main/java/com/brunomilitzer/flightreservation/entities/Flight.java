package com.brunomilitzer.flightreservation.entities;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Flight extends AbstractEntity {

    private String flightNumber;

    private String operatingAirlines;

    private String departureCity;

    private String arrivalCity;

    private Date dateOfDeparture;

    private Timestamp estimatedDepartureTime;


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

    @Override
    public String toString() {

        return "Flight [flightNumber=" + this.flightNumber + ", operatingAirlines=" + this.operatingAirlines + ", departureCity="
                + this.departureCity + ", arrivalCity=" + this.arrivalCity + ", dateOfDeparture=" + this.dateOfDeparture
                + ", estimatedDepartureTime=" + this.estimatedDepartureTime + "]";
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

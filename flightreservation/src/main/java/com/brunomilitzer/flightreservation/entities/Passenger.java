package com.brunomilitzer.flightreservation.entities;

import javax.persistence.Entity;

@Entity
public class Passenger extends AbstractEntity {

    private static final long serialVersionUID = -4810783638883511116L;

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private String phone;

    public String getFirstName() {

        return this.firstName;
    }

    public void setFirstName(final String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return this.lastName;
    }

    public void setLastName(final String lastName) {

        this.lastName = lastName;
    }

    public String getMiddleName() {

        return this.middleName;
    }

    public void setMiddleName(final String middleName) {

        this.middleName = middleName;
    }

    public String getEmail() {

        return this.email;
    }

    public void setEmail(final String email) {

        this.email = email;
    }

    public String getPhone() {

        return this.phone;
    }

    public void setPhone(final String phone) {

        this.phone = phone;
    }

}

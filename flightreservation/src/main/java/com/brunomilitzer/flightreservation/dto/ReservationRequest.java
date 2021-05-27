package com.brunomilitzer.flightreservation.dto;

public class ReservationRequest {

    private Long flightId;

    private String passengerFirstName;

    private String passengerLastName;

    private String passengerEmail;

    private String passengerPhone;

    private String nameOnTheCard;

    private String cardNumber;

    private String expirationDate;

    private String securityCode;

    public Long getFlightId() {

        return this.flightId;
    }

    public void setFlightId(final Long flightId) {

        this.flightId = flightId;
    }

    public String getPassengerFirstName() {

        return this.passengerFirstName;
    }

    public void setPassengerFirstName(final String passengerFirstName) {

        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerLastName() {

        return this.passengerLastName;
    }

    public void setPassengerLastName(final String passengerLastName) {

        this.passengerLastName = passengerLastName;
    }

    public String getPassengerEmail() {

        return this.passengerEmail;
    }

    public void setPassengerEmail(final String passengerEmail) {

        this.passengerEmail = passengerEmail;
    }

    public String getPassengerPhone() {

        return this.passengerPhone;
    }

    public void setPassengerPhone(final String passengerPhone) {

        this.passengerPhone = passengerPhone;
    }

    public String getNameOnTheCard() {

        return this.nameOnTheCard;
    }

    public void setNameOnTheCard(final String nameOnTheCard) {

        this.nameOnTheCard = nameOnTheCard;
    }

    public String getCardNumber() {

        return this.cardNumber;
    }

    public void setCardNumber(final String cardNumber) {

        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {

        return this.expirationDate;
    }

    public void setExpirationDate(final String expirationDate) {

        this.expirationDate = expirationDate;
    }

    public String getSecurityCode() {

        return this.securityCode;
    }

    public void setSecurityCode(final String securityCode) {

        this.securityCode = securityCode;
    }

    @Override
    public String toString() {

        return "ReservationRequest{" +
                "flightId=" + this.flightId +
                ", passengerFirstName='" + this.passengerFirstName + '\'' +
                ", passengerLastName='" + this.passengerLastName + '\'' +
                ", passengerEmail='" + this.passengerEmail + '\'' +
                ", passengerPhone='" + this.passengerPhone + '\'' +
                ", nameOnTheCard='" + this.nameOnTheCard + '\'' +
                ", cardNumber='" + this.cardNumber + '\'' +
                ", expirationDate='" + this.expirationDate + '\'' +
                ", securityCode='" + this.securityCode + '\'' +
                '}';
    }

}

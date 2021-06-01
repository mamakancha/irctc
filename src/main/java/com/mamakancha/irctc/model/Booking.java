package com.mamakancha.irctc.model;


import com.mamakancha.irctc.dao.DateTimeConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    /* attributes */
    @CsvBindByName(column = "bookingID")
    private int bookingID;

    @CsvCustomBindByName(column = "bookingDate", converter = DateTimeConverter.class)
    private LocalDateTime bookingDate;

    @CsvBindByName(column = "totalPrice")
    private double totalPrice;

    @CsvBindByName(column = "trainJourneyID")
    private int trainJourneyID;

    @CsvBindByName(column = "userID")
    private int userID;


    /* relationships */
    private TrainJourney trainJourney;

    // one booking can have multiple seats
    private List<JourneySeat> journeySeats = new ArrayList<>();

    // one booking has one user.
    private User user;


    /* getter and setters */
    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getTrainJourneyID() {
        return trainJourneyID;
    }

    public void setTrainJourneyID(int trainJourneyID) {
        this.trainJourneyID = trainJourneyID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public TrainJourney getTrainJourney() {
        return trainJourney;
    }

    public void setTrainJourney(TrainJourney trainJourney) {
        this.trainJourney = trainJourney;
    }


    public List<JourneySeat> getJourneySeats() {
        return journeySeats;
    }

    public void setJourneySeats(List<JourneySeat> journeySeats) {
        this.journeySeats = journeySeats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Booking() {}

    public Booking(User user, TrainJourney trainJourney){
        this.user = user;
        this.trainJourney = trainJourney;
    }

}

package com.mamakancha.irctc.model;

import com.mamakancha.irctc.dao.DateTimeConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TrainJourney {

    /* attributes */
    @CsvBindByName(column = "trainJourneyID")
    private int trainJourneyID;

    @CsvCustomBindByName(column = "trainJourneyStartTime", converter = DateTimeConverter.class)
    private LocalDateTime trainJourneyStartTime;

    @CsvCustomBindByName(column = "trainJourneyEndTime", converter = DateTimeConverter.class)
    private LocalDateTime trainJourneyEndTime;

    @CsvBindByName(column = "trainJourneyStartCity")
    private String trainJourneyStartCity;

    @CsvBindByName(column = "trainJourneyDestinationCity")
    private String trainJourneyDestinationCity;

    @CsvBindByName(column = "trainID")
    private int trainID;


    @CsvBindByName(column = "availableSeats")
    private int availableSeats;


    @CsvBindByName(column = "status")
    private String trainJourneyStatus = "ON_TIME";
    /* relationships */

    // one train journey can have multiple bookings
    List<Booking> bookings = new ArrayList<>();


    private Train train;

    // one train journey can have multiple journey seats
    List<JourneySeat> journeySeats = new ArrayList<>();




    /* getters and setters */
    public int getTrainJourneyID() {
        return trainJourneyID;
    }

    public void setTrainJourneyID(int trainJourneyID) {
        this.trainJourneyID = trainJourneyID;
    }

    public LocalDateTime getTrainJourneyStartTime() {
        return trainJourneyStartTime;
    }

    public void setTrainJourneyStartTime(LocalDateTime trainJourneyStartTime) {
        this.trainJourneyStartTime = trainJourneyStartTime;
    }

    public LocalDateTime getTrainJourneyEndTime() {
        return trainJourneyEndTime;
    }

    public void setTrainJourneyEndTime(LocalDateTime trainJourneyEndTime) {
        this.trainJourneyEndTime = trainJourneyEndTime;
    }

    public String getTrainJourneyStartCity() {
        return trainJourneyStartCity;
    }

    public void setTrainJourneyStartCity(String trainJourneyStartCity) {
        this.trainJourneyStartCity = trainJourneyStartCity;
    }

    public String getTrainJourneyDestinationCity() {
        return trainJourneyDestinationCity;
    }

    public void setTrainJourneyDestinationCity(String trainJourneyDestinationCity) {
        this.trainJourneyDestinationCity = trainJourneyDestinationCity;
    }



    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }


    public int getTrainID() {
        return trainID;
    }

    public void setTrainID(int trainID) {
        this.trainID = trainID;
    }


    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }


    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }


    public List<JourneySeat> getJourneySeats() {
        return journeySeats;
    }

    public void setJourneySeats(List<JourneySeat> journeySeats) {
        this.journeySeats = journeySeats;
    }


    public String getTrainJourneyStatus() {
        return trainJourneyStatus;
    }

    public void setTrainJourneyStatus(String trainJourneyStatus) {
        this.trainJourneyStatus = trainJourneyStatus;
    }

    public TrainJourney() {}

    public TrainJourney(Train train, LocalDateTime trainJourneyStartTime, LocalDateTime trainJourneyEndTime, String trainJourneyStartCity,
                        String trainJourneyDestinationCity) {
        this.train = train;
        this.trainJourneyStartTime = trainJourneyStartTime;
        this.trainJourneyEndTime = trainJourneyEndTime;
        this.trainJourneyStartCity = trainJourneyStartCity;
        this.trainJourneyDestinationCity = trainJourneyDestinationCity;
    }

}

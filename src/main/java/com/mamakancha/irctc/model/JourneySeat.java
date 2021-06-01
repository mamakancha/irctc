package com.mamakancha.irctc.model;

public class JourneySeat {

    /* attributes */
    private int journeySeatID;
    private int bookingID;
    private int trainJourneyID;
    private int physicalSeatID;

    /* relationships */
    private Booking booking;
    private PhysicalSeat physicalSeat;
    private TrainJourney trainJourney;


    /* getters and setters */
    public int getJourneySeatID() {
        return journeySeatID;
    }

    public void setJourneySeatID(int journeySeatID) {
        this.journeySeatID = journeySeatID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getTrainJourneyID() {
        return trainJourneyID;
    }

    public void setTrainJourneyID(int trainJourneyID) {
        this.trainJourneyID = trainJourneyID;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }


    public PhysicalSeat getPhysicalSeat() {
        return physicalSeat;
    }

    public void setPhysicalSeat(PhysicalSeat physicalSeat) {
        this.physicalSeat = physicalSeat;
    }


    public TrainJourney getTrainJourney() {
        return trainJourney;
    }

    public void setTrainJourney(TrainJourney trainJourney) {
        this.trainJourney = trainJourney;
    }

    public JourneySeat(){}

    public JourneySeat(int journeySeatID, int bookingID, int physicalSeatID, int trainJourneyID){
        this.journeySeatID = journeySeatID;
        this.bookingID = bookingID;
        this.physicalSeatID = physicalSeatID;
        this.trainJourneyID = trainJourneyID;
    }



}

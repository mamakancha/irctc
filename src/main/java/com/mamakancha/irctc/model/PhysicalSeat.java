package com.mamakancha.irctc.model;

import java.util.ArrayList;
import java.util.List;

public class PhysicalSeat {

    /* attributes */
    private int seatID;
    private String seatNumber;


    /* relationships */
    private Train train;
    private List<JourneySeat> journeySeatList = new ArrayList<>();


    /* getters and setters */
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public List<JourneySeat> getJourneySeatList() {
        return journeySeatList;
    }

    public void setJourneySeatList(List<JourneySeat> journeySeatList) {
        this.journeySeatList = journeySeatList;
    }


    public PhysicalSeat(int seatID, String seatNumber) {
        this.seatID = seatID;
        this.seatNumber = seatNumber;
    }
}

package com.mamakancha.irctc.model;

import java.util.ArrayList;
import java.util.List;

public class Train {

    /* attributes */
    private int trainID;
    private String trainName;

    private boolean mealOptions;
    private boolean luxury;


    /* relationships */
    private List<PhysicalSeat> physicalSeats = new ArrayList<>();
    private List<TrainJourney> trainJourneys = new ArrayList<>();


    /* getters and setters */
    public int getTrainID() {
        return trainID;
    }

    public void setTrainID(int trainID) {
        this.trainID = trainID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public boolean isMealOptions() {
        return mealOptions;
    }

    public void setMealOptions(boolean mealOptions) {
        this.mealOptions = mealOptions;
    }

    public boolean isLuxury() {
        return luxury;
    }

    public void setLuxury(boolean luxury) {
        this.luxury = luxury;
    }


    public List<PhysicalSeat> getPhysicalSeats() {
        return physicalSeats;
    }

    public void setPhysicalSeats(List<PhysicalSeat> physicalSeats) {
        this.physicalSeats = physicalSeats;
    }

    public List<TrainJourney> getTrainJourneys() {
        return trainJourneys;
    }

    public void setTrainJourneys(List<TrainJourney> trainJourneys) {
        this.trainJourneys = trainJourneys;
    }


    public Train(){}

    private Train(int trainID, String trainName){
        this.trainID = trainID;
        this.trainName = trainName;
    }

    /* Using builder pattern to build a train */
    public static class Builder {
        private int trainID;
        private String trainName;
        boolean luxury;
        boolean mealOptions;
        private List<PhysicalSeat> physicalSeats;
        private List<TrainJourney> trainJourneys;

        public Builder(int trainID, String trainName){
            this.trainID = trainID;
            this.trainName = trainName;
        }

        public Builder withLuxury(boolean luxury){
            this.luxury = luxury;
            return this;
        }

        public Builder withMealOptions(boolean mealOptions){
            this.mealOptions = mealOptions;
            return this;
        }

        public Builder withPhysicalSeats(List<PhysicalSeat> physicalSeats) {
            this.physicalSeats = physicalSeats;
            return this;
        }

        public Builder withTrainJourneys(List<TrainJourney> trainJourneys) {
            this.trainJourneys = trainJourneys;
            return this;
        }

        // can add more builder methods based on number of attributes

        public Train build(){
            Train train = new Train(trainID, trainName);
            train.setPhysicalSeats(physicalSeats);
            train.setTrainJourneys(trainJourneys);
            return train;
        }

    }

}

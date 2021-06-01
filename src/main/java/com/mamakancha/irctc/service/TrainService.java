package com.mamakancha.irctc.service;

import com.mamakancha.irctc.model.Train;
import com.mamakancha.irctc.model.TrainJourney;

import java.util.List;


public interface TrainService {

    public List<Train> getAllTrains();

    public List<TrainJourney> getTrainsByCity(String startCity, String destinationCity);

}
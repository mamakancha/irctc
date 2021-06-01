package com.mamakancha.irctc.dao;

import com.mamakancha.irctc.model.Train;
import com.mamakancha.irctc.model.TrainJourney;

import java.util.List;



public interface TrainDAO {

    public List<Train> getAllTrains();

    public List<TrainJourney> getAllTrainJourneys();

}

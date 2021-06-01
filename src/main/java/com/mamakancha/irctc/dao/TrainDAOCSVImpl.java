package com.mamakancha.irctc.dao;

import com.mamakancha.irctc.model.Train;

import com.mamakancha.irctc.model.TrainJourney;
import org.springframework.stereotype.Repository;

import java.io.File;

import java.util.List;


@Repository
public class TrainDAOCSVImpl implements  TrainDAO{

    public static String cwd = new File("").getAbsolutePath().toString();

    @Override
    public List<Train> getAllTrains(){

        List <Train> trains = CSVReaderUtility.getAllObjects(cwd + "/src/main/java/com/mamakancha/irctc/dao/trains.csv", Train.class);
        return trains;
    }

    @Override
    public List<TrainJourney> getAllTrainJourneys(){

        List<TrainJourney> trainJourneys = CSVReaderUtility.getAllObjects(cwd + "/src/main/java/com/mamakancha/irctc/dao/trainJourneys.csv", TrainJourney.class);
        return trainJourneys;
    }
}

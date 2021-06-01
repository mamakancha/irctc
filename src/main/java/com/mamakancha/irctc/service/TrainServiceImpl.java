package com.mamakancha.irctc.service;

import com.mamakancha.irctc.dao.TrainDAO;
import com.mamakancha.irctc.model.Train;
import com.mamakancha.irctc.model.TrainJourney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainServiceImpl implements  TrainService {

    @Autowired
    private TrainDAO trainDAO;

    @Override
    public List<Train> getAllTrains(){
        return trainDAO.getAllTrains();
    }

    @Override
    public List<TrainJourney> getTrainsByCity(String startCity, String destinationCity){
        List<TrainJourney> allTrainJourneys =  trainDAO.getAllTrainJourneys();
        List<Train> allTrains = trainDAO.getAllTrains();

        List<TrainJourney> trainJourneysWithCities =
                allTrainJourneys.stream().filter(train -> train.getTrainJourneyStartCity().equals(startCity)
                        && train.getTrainJourneyDestinationCity().equals(destinationCity)).collect(Collectors.toList());

        for(TrainJourney trainJourney : trainJourneysWithCities){
            for(Train train: allTrains){
                if(train.getTrainID() == trainJourney.getTrainID()){
                    trainJourney.setTrain(train);
                    break;
                }
            }
        }
        return trainJourneysWithCities;
    }
}

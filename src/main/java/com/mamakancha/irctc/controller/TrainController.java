package com.mamakancha.irctc.controller;


import com.mamakancha.irctc.model.Train;
import com.mamakancha.irctc.model.TrainJourney;
import com.mamakancha.irctc.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @RequestMapping("")
    public String welcome(){
        return "Welcome to Train Controller";
    }


    @RequestMapping("/getAllTrains")
    public List<Train> getAllTrains(){

        return trainService.getAllTrains();
    }

    @RequestMapping("/getTrainsByCity")
    public List<TrainJourney> getTrainsByCity(@RequestParam String startCity, String destinationCity){

        return trainService.getTrainsByCity(startCity, destinationCity);
    }
}

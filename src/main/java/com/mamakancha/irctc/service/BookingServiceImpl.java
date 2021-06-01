package com.mamakancha.irctc.service;

import com.mamakancha.irctc.dao.BookingDAO;
import com.mamakancha.irctc.dao.TrainDAO;
import com.mamakancha.irctc.model.Booking;
import com.mamakancha.irctc.model.TrainJourney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingDAO bookingDAO;

    @Autowired
    private TrainDAO trainDAO;

    @Override
    public List<Booking> getAllBookings(){
        return bookingDAO.getAllBookings();
    }

    @Override
    public List<Booking> getAllBookingsByUser(int userID){
        List<Booking> userBookings =  bookingDAO.getBookingsByUserID(userID);
        populateTrainJourneyInBookings(userBookings);
        return userBookings;
    }

    @Override
    public Booking saveBooking(int userID, int trainJourneyID, int totalPrice, int seats) throws Exception {
        TrainJourney trainJourney = findTrainJourney(trainJourneyID);
        if(trainJourney == null){
            throw new Exception("Not a valid train journey!!");
        }
        else if(trainJourney.getAvailableSeats() < seats){
            throw new Exception("Not enough seats!!");
        }
        else{
            return bookingDAO.saveBooking(userID, trainJourneyID, totalPrice, seats);
        }
    }



    private void populateTrainJourneyInBookings(List<Booking> bookings){
        List<TrainJourney> allTrainJourneys = trainDAO.getAllTrainJourneys();
        for(Booking booking : bookings){
            for(TrainJourney trainJourney : allTrainJourneys){
                if(booking.getTrainJourneyID() == trainJourney.getTrainJourneyID()){
                    booking.setTrainJourney(trainJourney);
                    break;
                }
            }
        }
    }

    private TrainJourney findTrainJourney(int trainJourneyID) {
        List<TrainJourney> allTrainJourneys = trainDAO.getAllTrainJourneys();
        TrainJourney trainJourneys = allTrainJourneys.stream().filter( trainJourney ->
                trainJourney.getTrainJourneyID() == trainJourneyID).findFirst().orElse(null);;

        return trainJourneys;
    }
}

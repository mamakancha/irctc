package com.mamakancha.irctc.controller;


import com.mamakancha.irctc.model.Booking;
import com.mamakancha.irctc.model.Train;
import com.mamakancha.irctc.service.BookingService;
import com.mamakancha.irctc.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping("")
    public String welcome(){
        return "Welcome to Booking Controller";
    }

    @RequestMapping("/getAllBookings")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @RequestMapping("/getAllBookingsByUser")
    public List<Booking> getAllBookingsByUser(@RequestParam int userID){
        return bookingService.getAllBookingsByUser(userID);
    }

    @PostMapping
    @RequestMapping("/saveBooking")
    public ResponseEntity<?> saveBooking(@RequestParam int userID, int trainJourneyID, int totalPrice, int seats) throws Exception {
        Booking booking = bookingService.saveBooking(userID, trainJourneyID, totalPrice, seats);
        return ResponseEntity.status(HttpStatus.CREATED).body(booking);
    }
}

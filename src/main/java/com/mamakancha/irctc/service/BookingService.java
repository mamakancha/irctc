package com.mamakancha.irctc.service;

import com.mamakancha.irctc.model.Booking;
import java.util.List;


public interface BookingService {

    public List<Booking> getAllBookings();

    public List<Booking> getAllBookingsByUser(int userID);

    public Booking saveBooking(int userID, int trainJourneyID, int totalPrice, int seats) throws Exception;
}

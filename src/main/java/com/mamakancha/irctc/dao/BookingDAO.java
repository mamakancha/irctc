package com.mamakancha.irctc.dao;

import com.mamakancha.irctc.model.Booking;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BookingDAO {

    public List<Booking> getAllBookings();

    public List<Booking> getBookingsByUserID(int userID);

    public Booking saveBooking(int userID, int trainJourneyID, int totalPrice, int seats) throws IOException;


}
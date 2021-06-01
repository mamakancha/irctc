package com.mamakancha.irctc.dao;

import com.mamakancha.irctc.model.Booking;
import com.mamakancha.irctc.model.JourneySeat;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookingDAOCSVImpl implements BookingDAO {

    public static String cwd = new File("").getAbsolutePath().toString();

    @Override
    public List<Booking> getAllBookings(){

        List <Booking> allBookings = CSVReaderUtility.
                getAllObjects(cwd + "/src/main/java/com/mamakancha/irctc/dao/bookings.csv", Booking.class);
        return allBookings;
    }

    @Override
    public List<Booking> getBookingsByUserID(int userID){
        return getAllBookings().stream().filter(booking -> booking.getUserID() == userID)
                .collect(Collectors.toList());

    }

    @Override
    public Booking saveBooking(int userID, int trainJourneyID, int totalPrice, int seats) throws IOException{
        int maxBookingID = CSVReaderUtility
                .getMaxValueFromCSV(0, cwd + "/src/main/java/com/mamakancha/irctc/dao/bookings.csv");

        int bookingID = maxBookingID +1; // will not work like this in a multi-threaded environment.
        LocalDateTime bookingDate = LocalDateTime.now();



        Booking booking = new Booking();
        booking.setUserID(userID);
        booking.setBookingID(bookingID);
        booking.setBookingDate(bookingDate);
        booking.setTrainJourneyID(trainJourneyID);
        booking.setTotalPrice(totalPrice);
        // can pppulate trainJourney for the booking as well
        allotSeatsToUser(booking, seats);

        String[] record = {String.valueOf(bookingID), bookingDate.toString(), String.valueOf(totalPrice), String.valueOf(trainJourneyID), String.valueOf(userID)};
        CSVWriterUtility.appendToCSV(cwd + "/src/main/java/com/mamakancha/irctc/dao/bookings.csv", record);
        return booking;

    }

    private void allotSeatsToUser(Booking booking, int seats) throws IOException {
        CSVReader reader = new CSVReaderBuilder(new FileReader(cwd + "/src/main/java/com/mamakancha/irctc/dao/journeySeats.csv")).build();
        List<String[]> csvBody = reader.readAll();
        List<JourneySeat> journeySeats = new ArrayList<>();
        int numberOfSeatsAlloted = 0;
        for (String[] strArray : csvBody) {
            if (strArray[2].equalsIgnoreCase("-1") && strArray[3].equalsIgnoreCase(String.valueOf(booking.getTrainJourneyID()))) {
                strArray[2] = String.valueOf(booking.getBookingID());
                JourneySeat journeySeat = new JourneySeat(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[2])
                        , Integer.parseInt(strArray[1]), Integer.parseInt(strArray[3]));
                journeySeats.add(journeySeat);
                numberOfSeatsAlloted++;
                if(numberOfSeatsAlloted == seats) break;

            }
        }
        /* reduce the count of seats from trainJounreys.csv as well */
        
        booking.setJourneySeats(journeySeats);
        // we can further populate PhysicalSeats in each JourneySeat object if required
        reader.close();

        FileWriter writer = new FileWriter(cwd + "/src/main/java/com/mamakancha/irctc/dao/journeySeats.csv");
        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeAll(csvBody);
        csvWriter.flush();
        csvWriter.close();
    }
}

package edu.psu.se411.lab07;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.psu.se411.lab07.exceptions.InvalidArgumentException;
import edu.psu.se411.lab07.exceptions.MissingInformationException;
import edu.psu.se411.lab07.model.*;
import edu.psu.se411.lab07.util.SeatClass;

public class App {

    static Logger logger = LoggerFactory.getLogger(App.class);

    // Polymorphism: works for ANY booking type
    public static double computeTotalPrice(Booking booking)
            throws MissingInformationException, InvalidArgumentException {
        return booking.calculateTotalPrice();
    }

    private static void printPrice(Booking booking) {
        try {
            System.out.println(booking + " -> Total Price: " + computeTotalPrice(booking));
        } catch (MissingInformationException e) {
            logger.error("MissingInformationException: " + e.getMessage());
            System.out.println(booking + " -> ERROR: " + e.getMessage());
        } catch (InvalidArgumentException e) {
            logger.error("InvalidArgumentException: " + e.getMessage());
            System.out.println(booking + " -> ERROR: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        logger.info("Application is starting...");

        // Valid bookings (from the lab sheet)
        Booking fbooking = new FlightBooking("B001", "John Doe", new Date(), "New York", 200.0, 30.0, 20.0);
        printPrice(fbooking);

        Booking cbooking = new CarRentalBooking("B002", "Jane Smith", new Date(), "Los Angeles", 50.0, 10);
        printPrice(cbooking);

        SeatClass seatClass = SeatClass.STANDARD_CLASS;
        Booking tbooking = new TrainBooking("B003", "Alice Johnson", new Date(), "Chicago", seatClass, 100.0);
        printPrice(tbooking);

        // Invalid bookings (test the exceptions)
        printPrice(new FlightBooking("B004", "Sara Ali", new Date(), "Dubai", 300.0, 20.0, 55.0));
        printPrice(new FlightBooking("B005", "Omar Khan", new Date(), "Cairo", 250.0, 20.0));
        printPrice(new TrainBooking("B006", "Lina Saad", new Date(), "Jeddah", SeatClass.FIRST_CLASS, 2500.0));
        printPrice(new CarRentalBooking("B007", "Nora Fahad", new Date(), "Abha", 60.0));

        logger.info("Application is stopping...");
    }
}
package edu.psu.se411.lab07.model;

import java.util.Date;
import edu.psu.se411.lab07.exceptions.InvalidArgumentException;
import edu.psu.se411.lab07.exceptions.MissingInformationException;
import edu.psu.se411.lab07.util.Config;

public class CarRentalBooking extends Booking {

private double dailyRate;
private Integer numberOfDays;

public CarRentalBooking(String bookingId, String customerName, Date travelDate, String destinationCity,
double dailyRate) {
super(bookingId, customerName, travelDate, destinationCity);
this.dailyRate = dailyRate;
}

public CarRentalBooking(String bookingId, String customerName, Date travelDate, String destinationCity,
double dailyRate, int numberOfDays) {
this(bookingId, customerName, travelDate, destinationCity, dailyRate);
this.numberOfDays = numberOfDays;
}

public void setNumberOfDays(Integer numberOfDays) { this.numberOfDays = numberOfDays; }

@Override
public double calculateTotalPrice() throws MissingInformationException, InvalidArgumentException {
if (numberOfDays == null) {
throw new MissingInformationException("Number of days not provided for booking " + getBookingId());
}
if (numberOfDays < Config.MIN_RENTAL_DAYS || numberOfDays > Config.MAX_RENTAL_DAYS) {
throw new InvalidArgumentException("Rental days " + numberOfDays + " is outside 1-30 for booking " + getBookingId());
}
return dailyRate * numberOfDays;
}
}



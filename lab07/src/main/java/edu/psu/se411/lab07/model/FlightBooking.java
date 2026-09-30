package edu.psu.se411.lab07.model;

import java.util.Date;
import edu.psu.se411.lab07.exceptions.InvalidArgumentException;
import edu.psu.se411.lab07.exceptions.MissingInformationException;
import edu.psu.se411.lab07.util.Config;

public class FlightBooking extends Booking {

private double baseTicketPrice;
private double includedLuggageWeight;
private Double luggageWeight; // Double (not double) so it can be null = "not provided"

public FlightBooking(String bookingId, String customerName, Date travelDate, String destinationCity,
double baseTicketPrice, double includedLuggageWeight) {
super(bookingId, customerName, travelDate, destinationCity);
this.baseTicketPrice = baseTicketPrice;
this.includedLuggageWeight = includedLuggageWeight;
}

public FlightBooking(String bookingId, String customerName, Date travelDate, String destinationCity,
double baseTicketPrice, double includedLuggageWeight, double luggageWeight) {
this(bookingId, customerName, travelDate, destinationCity, baseTicketPrice, includedLuggageWeight);
this.luggageWeight = luggageWeight;
}

public void setLuggageWeight(Double luggageWeight) { this.luggageWeight = luggageWeight; }

@Override
public double calculateTotalPrice() throws MissingInformationException, InvalidArgumentException {
if (luggageWeight == null) {
throw new MissingInformationException("Luggage weight not provided for booking " + getBookingId());
}
if (luggageWeight < Config.MIN_LUGGAGE_WEIGHT || luggageWeight > Config.MAX_LUGGAGE_WEIGHT) {
throw new InvalidArgumentException("Luggage weight " + luggageWeight + " kg is outside 0-40 kg for booking " + getBookingId());
}
double extraKg = Math.max(0, luggageWeight - includedLuggageWeight); // no negative extra
double subtotal = baseTicketPrice + extraKg * Config.EXTRA_LUGGAGE_RATE;
return subtotal * (1 + Config.TAX_RATE);
}
}



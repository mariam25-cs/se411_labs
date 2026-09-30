package edu.psu.se411.lab07.model;

import java.util.Date;
import edu.psu.se411.lab07.exceptions.InvalidArgumentException;
import edu.psu.se411.lab07.exceptions.MissingInformationException;
import edu.psu.se411.lab07.util.Config;
import edu.psu.se411.lab07.util.SeatClass;

public class TrainBooking extends Booking {

private SeatClass seatClass;
private Double distanceKm;

public TrainBooking(String bookingId, String customerName, Date travelDate, String destinationCity,
SeatClass seatClass) {
super(bookingId, customerName, travelDate, destinationCity);
this.seatClass = seatClass;
}

public TrainBooking(String bookingId, String customerName, Date travelDate, String destinationCity,
SeatClass seatClass, double distanceKm) {
this(bookingId, customerName, travelDate, destinationCity, seatClass);
this.distanceKm = distanceKm;
}

public void setDistanceKm(Double distanceKm) { this.distanceKm = distanceKm; }

@Override
public double calculateTotalPrice() throws MissingInformationException, InvalidArgumentException {
if (distanceKm == null) {
throw new MissingInformationException("Distance not provided for booking " + getBookingId());
}
if (distanceKm < Config.MIN_TRAIN_DISTANCE || distanceKm > Config.MAX_TRAIN_DISTANCE) {
throw new InvalidArgumentException("Distance " + distanceKm + " km is outside 1-2000 km for booking " + getBookingId());
}
double rate = (seatClass == SeatClass.FIRST_CLASS)
? Config.TRAIN_FIRST_CLASS_RATE
: Config.TRAIN_STANDARD_RATE;
return distanceKm * rate;
}
}



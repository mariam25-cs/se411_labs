package edu.psu.se411.lab07.model;

import java.util.Date;
import edu.psu.se411.lab07.exceptions.InvalidArgumentException;
import edu.psu.se411.lab07.exceptions.MissingInformationException;

// Parent class: shared fields live here once (code reuse)
public abstract class Booking {

private String bookingId;
private String customerName;
private Date travelDate;
private String destinationCity;

public Booking(String bookingId, String customerName, Date travelDate, String destinationCity) {
this.bookingId = bookingId;
this.customerName = customerName;
this.travelDate = travelDate;
this.destinationCity = destinationCity;
}

// Each subclass writes its own version (polymorphism)
public abstract double calculateTotalPrice()
throws MissingInformationException, InvalidArgumentException;

public String getBookingId() { return bookingId; }
public String getCustomerName() { return customerName; }
public Date getTravelDate() { return travelDate; }
public String getDestinationCity() { return destinationCity; }

@Override
public String toString() {
return getClass().getSimpleName() + "[" + bookingId + ", " + customerName + ", " + destinationCity + "]";
}
}

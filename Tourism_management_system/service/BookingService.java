package com.Tourism.service;

import java.util.List;

import com.Tourism.entity.Booking;

/**
 * BookingService interface provides abstract methods
 * for performing CRUD operations on Booking entities.
 */
public interface BookingService {

	// Adds a new Booking entity
	void addBooking(Booking booking);

	// Updates an existing Booking entity
	void updateBooking(Booking booking);

	// Deletes a Booking entity by its ID
	void deleteBooking(int id);

	// Retrieves a Booking entity by its ID
	Booking getBookingById(int id);

	// Retrieves a list of all Booking entities
	List<Booking> getAllBookings();
}

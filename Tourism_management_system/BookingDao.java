package com.Tourism.Dao;

import java.util.List;
import com.Tourism.entity.Booking;

/**
 * BookingDao interface provides abstract methods for performing
 * CRUD operations on Route entities.
 */
public interface BookingDao {

	// Adds a new Booking entity to the database
	void add(Booking booking);

	// Updates an existing Booking entity in the database
	void update(Booking booking);

	// Deletes a Booking entity by its ID
	void delete(int id);

	// Retrieves a Booking entity by its ID
	Booking getById(int id);

	// Retrieves all Booking entities
	List<Booking> getAll();
}

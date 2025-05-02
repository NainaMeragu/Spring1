package com.Tourism.Dao;

import java.util.List;
import com.Tourism.entity.Ticket;

/**
 * TicketDao interface provides abstract methods for performing
 * CRUD operations on Ticket entities.
 */
public interface TicketDao {

	/**
	 * Adds a new ticket to the database.
	 * @param ticket the ticket entity to add
	 */
	void add(Ticket ticket);

	/**
	 * Updates an existing ticket in the database.
	 * @param ticket the ticket entity to update
	 */
	void update(Ticket ticket);

	/**
	 * Deletes a ticket by its ID.
	 * @param id the ID of the ticket to delete
	 */
	void delete(int id);

	/**
	 * Retrieves a ticket by its ID.
	 * @param id the ID of the ticket
	 * @return the ticket entity, or null if not found
	 */
	Ticket getById(int id);

	/**
	 * Retrieves all tickets from the database.
	 * @return a list of all tickets
	 */
	List<Ticket> getAll();

}

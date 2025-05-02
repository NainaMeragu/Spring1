package com.Tourism.service;

import java.util.List;
import com.Tourism.entity.Ticket;

/**
 * TicketService interface provides abstract methods
 * for performing CRUD operations on Ticket entities.
 */
public interface TicketService {

	// Adds a new Ticket entity
	void addTicket(Ticket ticket);

	// Updates an existing Ticket entity
	void updateTicket(Ticket ticket);

	// Deletes a Ticket entity by its ID
	void deleteTicket(int id);

	// Retrieves a Ticket entity by its ID
	Ticket getTicketById(int id);

	// Retrieves a list of all Ticket entities
	List<Ticket> getAllTickets();
}

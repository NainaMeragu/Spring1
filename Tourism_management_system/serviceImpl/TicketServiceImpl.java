package com.Tourism.serviceImpl;

import java.util.List;
import com.Tourism.entity.Ticket;
import com.Tourism.service.TicketService;
import com.Tourism.Dao.TicketDao;
import com.Tourism.DaoImpl.TicketDaoImpl;

/**
 * TicketServiceImpl class implements the TicketService interface and provides
 * the actual logic for performing CRUD operations on Ticket entities.
 */
public class TicketServiceImpl implements TicketService{

	// Instance of TicketDao to interact with the data layer
	private TicketDao ticketDao = new TicketDaoImpl();

	/**
	 * Adds a new Ticket entity to the database.
	 * @param ticket The Ticket object to be added.
	 */
	@Override
	public void addTicket(Ticket ticket) {
		ticketDao.add(ticket);
	}

	/**
	 * Updates an existing Ticket entity in the database.
	 * @param ticket The Ticket object to be updated.
	 */
	@Override
	public void updateTicket(Ticket ticket) {
		ticketDao.update(ticket);
	}

	/**
	 * Deletes a Ticket entity from the database by its ID.
	 * @param id The ID of the Ticket to be deleted.
	 */
	@Override
	public void deleteTicket(int id) {
		ticketDao.delete(id);
	}

	/**
	 * Retrieves a Ticket entity by its ID.
	 * @param id The ID of the Ticket to be retrieved.
	 * @return The Ticket entity with the specified ID.
	 */
	@Override
	public Ticket getTicketById(int id) {
		return ticketDao.getById(id);
	}

	/**
	 * Retrieves all Ticket entities from the database.
	 * @return A list of all Ticket entities.
	 */
	@Override
	public List<Ticket> getAllTickets() {
		return ticketDao.getAll();
	}
}

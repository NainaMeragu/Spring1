package com.Tourism.DaoImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Tourism.Dao.TicketDao;
import com.Tourism.entity.Ticket;
import com.Tourism.util.HibernateUtil;

/**
 * TicketDaoImpl provides the implementation of CRUD operations 
 * defined in the TicketDao interface using Hibernate ORM framework.
 */
public class TicketDaoImpl implements TicketDao{

	// Adds a new Ticket entity to the database
	@Override
	public void add(Ticket ticket) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Save ticket entity
			session.save(ticket);
			// Commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Updates an existing Ticket entity in the database
	@Override
	public void update(Ticket ticket) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Update ticket entity
			session.update(ticket);
			// Commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Deletes a Ticket entity from the database by its ID
	@Override
	public void delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Retrieve ticket by ID
			Ticket ticket = session.get(Ticket.class, id);
			if (ticket != null) {
				// Delete ticket entity
				session.delete(ticket);
				// Commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Retrieves a Ticket entity by its ID
	@Override
	public Ticket getById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Fetch ticket entity by ID
			return session.get(Ticket.class, id);
		}
	}

	// Retrieves a list of all Ticket entities from the database
	@Override
	public List<Ticket> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Query all Ticket entities
			return session.createQuery("FROM Ticket", Ticket.class).list();
		}
	}
}

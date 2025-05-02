package com.Tourism.DaoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Tourism.Dao.BookingDao;
import com.Tourism.entity.Booking;
import com.Tourism.util.HibernateUtil;

import java.util.List;

/**
 * BookingDaoImpl provides the implementation of CRUD operations
 * for Booking entities using Hibernate ORM framework.
 */
public class BookingDaoImpl implements BookingDao{

	// Adds a new Booking entity to the database
	@Override
	public void add(Booking booking) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Save booking entity
			session.save(booking);
			// Commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Updates an existing Booking entity in the database
	@Override
	public void update(Booking booking) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Update booking entity
			session.update(booking);
			// Commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Deletes a Booking entity from the database by its ID
	@Override
	public void delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Retrieve booking by ID
			Booking booking = session.get(Booking.class, id);
			if (booking != null) {
				// Delete booking entity
				session.delete(booking);
				// Commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Retrieves a Booking entity by its ID
	@Override
	public Booking getById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Fetch booking entity by ID
			return session.get(Booking.class, id);
		}
	}

	// Retrieves a list of all Booking entities from the database
	@Override
	public List<Booking> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Query all Booking entities
			return session.createQuery("FROM Booking", Booking.class).list();
		}
	}
}

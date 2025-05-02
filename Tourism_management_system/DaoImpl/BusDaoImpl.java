package com.Tourism.DaoImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Tourism.Dao.BusDao;
import com.Tourism.entity.Bus;
import com.Tourism.util.HibernateUtil;

/**
 * BusDaoImpl provides the implementation of CRUD operations
 * defined in the BusDao interface using Hibernate ORM framework.
 */
public class BusDaoImpl implements BusDao{

	// Adds a new Bus entity to the database
	@Override
	public void add(Bus bus) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Save bus entity
			session.save(bus);
			// Commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Updates an existing Bus entity in the database
	@Override
	public void update(Bus bus) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Update bus entity
			session.update(bus);
			// Commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Deletes a Bus entity from the database by its ID
	@Override
	public void delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Retrieve bus by ID
			Bus bus = session.get(Bus.class, id);
			if (bus != null) {
				// Delete bus entity
				session.delete(bus);
				// Commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Retrieves a Bus entity by its ID
	@Override
	public Bus getById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Fetch bus entity by ID
			return session.get(Bus.class, id);
		}
	}

	// Retrieves a list of all Bus entities from the database
	@Override
	public List<Bus> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Query all Bus entities
			return session.createQuery("FROM Bus", Bus.class).list();
		}
	}
}

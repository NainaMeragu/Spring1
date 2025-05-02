package com.Tourism.DaoImpl;

import com.Tourism.Dao.RouteDao;
import com.Tourism.entity.Route;
import com.Tourism.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 * RouteDaoImpl provides the implementation of CRUD operations 
 * defined in the RouteDao interface using Hibernate ORM framework.
 */
public class RouteDaoImpl implements RouteDao{

	// Adds a new Route entity to the database
	@Override
	public void add(Route route) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Save route entity
			session.save(route);
			// Commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Updates an existing Route entity in the database
	@Override
	public void update(Route route) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Update route entity
			session.update(route);
			// Commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Deletes a Route entity from the database by its ID
	@Override
	public void delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Retrieve route by ID
			Route route = session.get(Route.class, id);
			if (route != null) {
				// Delete route entity
				session.delete(route);
				// Commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Retrieves a Route entity by its ID
	@Override
	public Route getById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Fetch route entity by ID
			return session.get(Route.class, id);
		}
	}

	// Retrieves a list of all Route entities from the database
	@Override
	public List<Route> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Query all Route entities
			return session.createQuery("FROM Route", Route.class).list();
		}
	}
}

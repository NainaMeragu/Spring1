package com.Tourism.DaoImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Tourism.Dao.FeedbackDao;
import com.Tourism.entity.Feedback;
import com.Tourism.util.HibernateUtil;

/**
 * FeedbackDaoImpl provides the implementation of CRUD operations 
 * defined in the FeedbackDao interface using Hibernate ORM framework.
 */
public class FeedbackDaoImpl implements FeedbackDao{

	// Adds a new Feedback entity to the database
	@Override
	public void add(Feedback feedback) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Save feedback entity
			session.save(feedback);
			// Commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Updates an existing Feedback entity in the database
	@Override
	public void update(Feedback feedback) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Update feedback entity
			session.update(feedback);
			// Commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Deletes a Feedback entity from the database by its ID
	@Override
	public void delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Retrieve feedback by ID
			Feedback feedback = session.get(Feedback.class, id);
			if (feedback != null) {
				// Delete feedback entity
				session.delete(feedback);
				// Commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}
	// Retrieves a Feedback entity by its ID
	@Override
	public Feedback getById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Fetch feedback entity by ID
			return session.get(Feedback.class, id);
		}
	}

	// Retrieves a list of all Feedback entities from the database
	@Override
	public List<Feedback> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Query all Feedback entities
			return session.createQuery("FROM Feedback", Feedback.class).list();
		}
	}
}

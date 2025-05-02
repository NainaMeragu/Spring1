package com.Tourism.DaoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.Tourism.Dao.UserDao;
import com.Tourism.entity.User;
import com.Tourism.util.HibernateUtil;
import java.util.List;

/**
 * UserDaoImpl provides the implementation of the CRUD operations 
 * defined in the UserDao interface, utilizing Hibernate ORM for database interaction.
 */

public class UserDaoImpl implements UserDao{

	// Adds a new User entity to the database
	@Override
	public void add(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Save user entity
			session.save(user);
			// Commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Updates an existing User entity in the database
	@Override
	public void update(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Update user entity
			session.update(user);
			// Commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Deletes a User entity from the database by its ID
	@Override
	public void delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Begin transaction
			transaction = session.beginTransaction();
			// Retrieve user by ID
			User user = session.get(User.class, id);
			if (user != null) {
				// Delete user entity
				session.delete(user);
				// Commit transaction
				transaction.commit();
			}
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	// Retrieves a User entity by its ID
	@Override
	public User getById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Fetch user entity by ID
			return session.get(User.class, id);
		}
	}

	// Retrieves a list of all User entities from the database
	@Override
	public List<User> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Query all User entities
			return session.createQuery("FROM User", User.class).list();
		}
	}
}

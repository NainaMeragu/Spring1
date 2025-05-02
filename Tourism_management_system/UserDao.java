package com.Tourism.Dao;

import java.util.List;
import com.Tourism.entity.User;

/* 
 * UserDao interface provides abstract methods for performing 
 * CRUD operations on User entities.
 */

public interface UserDao {

	/**
	 * Adds a new user to the database.
	 * @param user the user entity to add
	 */
	void add(User user);

	/**
	 * Updates an existing user in the database.
	 * @param user the user entity to update
	 */
	void update(User user);

	/**
	 * Deletes a user by their ID.
	 * @param id the ID of the user to delete
	 */
	void delete(int id);

	/**
	 * Retrieves a user by their ID.
	 * @param id the ID of the user
	 * @return the user entity, or null if not found
	 */
	User getById(int id);

	/**
	 * Retrieves all users from the database.
	 * @return a list of all users
	 */
	List<User> getAll();
}

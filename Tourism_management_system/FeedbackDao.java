package com.Tourism.Dao;

import java.util.List;
import com.Tourism.entity.Feedback;

/**
 * FeedbackDao interface provides abstract methods for performing
 * CRUD operations on Feedback entities.
 */
public interface FeedbackDao {

	/**
	 * Adds a new feedback entry to the database.
	 * @param feedback the feedback entity to add
	 */
	void add(Feedback feedback);

	/**
	 * Updates an existing feedback entity in the database. 
	 * @param feedback the feedback entity to update
	 */
	void update(Feedback feedback);

	/**
	 * Deletes a feedback entity by its ID.
	 * @param id the ID of the feedback entity to delete
	 */
	void delete(int id);

	/**
	 * Retrieves a feedback entity by its ID.
	 * @param id the ID of the feedback entity
	 * @return the feedback entity, or null if not found
	 */
	Feedback getById(int id);

	/**
	 * Retrieves all feedback entities from the database.
	 * @return a list of all feedback entities
	 */
	List<Feedback> getAll();
}

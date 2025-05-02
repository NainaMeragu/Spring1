package com.Tourism.service;

import java.util.List;
import com.Tourism.entity.Feedback;

/**
 * FeedbackService interface provides abstract methods
 * for performing CRUD operations on Feedback entities.
 */
public interface FeedbackService {

	// Adds a new Feedback entity
	void addFeedback(Feedback feedback);

	// Updates an existing Feedback entity
	void updateFeedback(Feedback feedback);

	// Deletes a Feedback entity by its ID
	void deleteFeedback(int id);

	// Retrieves a Feedback entity by its ID
	Feedback getFeedbackById(int id);

	// Retrieves a list of all Feedback entities
	List<Feedback> getAllFeedbacks();
}

package com.Tourism.serviceImpl;

import java.util.List;
import com.Tourism.Dao.FeedbackDao;
import com.Tourism.DaoImpl.FeedbackDaoImpl;
import com.Tourism.entity.Feedback;
import com.Tourism.service.FeedbackService;

/**
 * FeedbackServiceImpl class implements the FeedbackService interface and provides
 * the actual logic for performing CRUD operations on Feedback entities.
 */
public class FeedbackServiceImpl implements FeedbackService{

	// Instance of FeedbackDao to interact with the data layer
	private FeedbackDao feedbackDao = new FeedbackDaoImpl();

	/**
	 * Adds a new Feedback entity to the database.
	 * @param feedback The Feedback object to be added.
	 */
	@Override
	public void addFeedback(Feedback feedback) {
		feedbackDao.add(feedback);
	}

	/**
	 * Updates an existing Feedback entity in the database.
	 * @param feedback The Feedback object to be updated.
	 */
	@Override
	public void updateFeedback(Feedback feedback) {
		feedbackDao.update(feedback);
	}

	/**
	 * Deletes a Feedback entity from the database by its ID.
	 * @param id The ID of the Feedback to be deleted.
	 */
	@Override
	public void deleteFeedback(int id) {
		feedbackDao.delete(id);
	}

	/**
	 * Retrieves a Feedback entity by its ID.
	 * @param id The ID of the Feedback to be retrieved.
	 * @return The Feedback entity with the specified ID.
	 */
	@Override
	public Feedback getFeedbackById(int id) {
		return feedbackDao.getById(id);
	}

	/**
	 * Retrieves all Feedback entities from the database.
	 * @return A list of all Feedback entities.
	 */
	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackDao.getAll();
	}
}

package com.Tourism.serviceImpl;

import java.util.List;
import com.Tourism.Dao.UserDao;
import com.Tourism.DaoImpl.UserDaoImpl;
import com.Tourism.entity.User;
import com.Tourism.service.UserService;

/**
 * UserServiceImpl class implements the UserService interface and provides
 * the actual logic for performing CRUD operations on User entities.
 */
public class UserServiceImpl implements UserService{

	// Instance of UserDao to interact with the data layer
	private UserDao userDao = new UserDaoImpl();

	/**
	 * Adds a new User entity to the database.
	 * @param user The User object to be added.
	 */
	@Override
	public void addUser(User user) {
		userDao.add(user);
	}

	/**
	 * Updates an existing User entity in the database.
	 * @param user The User object to be updated.
	 */
	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	/**
	 * Deletes a User entity from the database by its ID.
	 * @param userId The ID of the User to be deleted.
	 */
	@Override
	public void deleteUser(int userId) {
		userDao.delete(userId);
	}

	/**
	 * Retrieves a User entity by its ID.
	 * @param userId The ID of the User to be retrieved.
	 * @return The User entity with the specified ID.
	 */
	@Override
	public User getUserById(int userId) {
		return userDao.getById(userId);
	}

	/**
	 * Retrieves all User entities from the database.
	 * @return A list of all User entities.
	 */
	@Override
	public List<User> getAllUsers() {
		return userDao.getAll();
	}
}

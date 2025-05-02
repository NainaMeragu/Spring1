package com.Tourism.service;

import java.util.List;
import com.Tourism.entity.User;

/**
 * UserService interface provides abstract methods
 * for performing CRUD operations on User entities.
 */
public interface UserService {

	// Adds a new User entity
	void addUser(User user);

	// Updates an existing User entity
	void updateUser(User user);

	// Deletes a User entity by its ID
	void deleteUser(int id);

	// Retrieves a User entity by its ID
	User getUserById(int id);

	// Retrieves a list of all User entities
	List<User> getAllUsers();
}

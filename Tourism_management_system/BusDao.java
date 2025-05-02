package com.Tourism.Dao;

import java.util.List;
import com.Tourism.entity.Bus;

/* 
 * BusDao interface provides abstract methods for performing 
 * CRUD operations on User entities.
 */
public interface BusDao {

	// Adds a new Bus entity to the database
	void add(Bus bus);

	// Updates an existing Bus entity in the database
	void update(Bus bus);

	// Deletes a Bus entity by its ID
	void delete(int id);

	// Retrieves a Bus entity by its ID
	Bus getById(int id);

	// Retrieves all Bus entities
	List<Bus> getAll();
}

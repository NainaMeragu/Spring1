package com.Tourism.service;

import java.util.List;

import com.Tourism.entity.Bus;

/**
 * BusService interface provides abstract methods
 * for performing CRUD operations on Bus entities.
 */
public interface BusService {

	// Adds a new Bus entity
	void addBus(Bus bus);

	// Updates an existing Bus entity
	void updateBus(Bus bus);

	// Deletes a Bus entity by its ID
	void deleteBus(int id);

	// Retrieves a Bus entity by its ID
	Bus getBusById(int id);

	// Retrieves a list of all Bus entities
	List<Bus> getAllBuses();
}

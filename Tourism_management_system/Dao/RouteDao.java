package com.Tourism.Dao;

import java.util.List;
import com.Tourism.entity.Route;

/**
 * RouteDao interface provides abstract methods for performing
 * CRUD operations on Route entities.
 */
public interface RouteDao {

	/**
	 * Adds a new route to the database.
	 * @param route the route entity to add
	 */
	void add(Route route);

	/**
	 * Updates an existing route in the database.
	 * @param route the route entity to update
	 */
	void update(Route route);

	/**
	 * Deletes a route by its ID.
	 * @param id the ID of the route to delete
	 */
	void delete(int id);

	/**
	 * Retrieves a route by its ID.
	 * @param id the ID of the route
	 * @return the route entity, or null if not found
	 */
	Route getById(int id);

	/**
	 * Retrieves all routes from the database.
	 * @return a list of all routes
	 */
	List<Route> getAll();
}

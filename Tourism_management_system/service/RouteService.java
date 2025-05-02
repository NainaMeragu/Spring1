package com.Tourism.service;

import java.util.List;

import com.Tourism.entity.Route;

/**
 * RouteService interface provides abstract methods
 * for performing CRUD operations on Route entities.
 */
public interface RouteService {

	// Adds a new Route entity
	void addRoute(Route route);

	// Updates an existing Route entity
	void updateRoute(Route route);

	// Deletes a Route entity by its ID
	void deleteRoute(int id);

	// Retrieves a Route entity by its ID
	Route getRouteById(int id);

	// Retrieves a list of all Route entities
	List<Route> getAllRoutes();
}

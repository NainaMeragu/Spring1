package com.Tourism.serviceImpl;

import com.Tourism.Dao.RouteDao;
import com.Tourism.DaoImpl.RouteDaoImpl;
import com.Tourism.entity.Route;
import com.Tourism.service.RouteService;
import java.util.List;

/**
 * RouteServiceImpl class implements the RouteService interface and provides
 * the actual logic for performing CRUD operations on Route entities.
 */
public class RouteServiceImpl implements RouteService{

	// Instance of RouteDao to interact with the data layer
	private RouteDao routeDao = new RouteDaoImpl();

	/**
	 * Adds a new Route entity to the database.
	 * @param route The Route object to be added.
	 */
	@Override
	public void addRoute(Route route) {
		routeDao.add(route);
	}

	/**
	 * Retrieves a Route entity by its ID.
	 * @param id The ID of the Route to be retrieved.
	 * @return The Route entity with the specified ID.
	 */
	@Override
	public Route getRouteById(int id) {
		return routeDao.getById(id);
	}

	/**
	 * Retrieves all Route entities from the database.
	 * @return A list of all Route entities.
	 */
	@Override
	public List<Route> getAllRoutes() {
		return routeDao.getAll();
	}

	/**
	 * Updates an existing Route entity in the database.
	 * @param route The Route object to be updated.
	 */
	@Override
	public void updateRoute(Route route) {
		routeDao.update(route);
	}

	/**
	 * Deletes a Route entity from the database by its ID.
	 * @param id The ID of the Route to be deleted.
	 */
	@Override
	public void deleteRoute(int id) {
		routeDao.delete(id);
	}
}

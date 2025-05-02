package com.Tourism.serviceImpl;

import java.util.List;
import com.Tourism.entity.Bus;
import com.Tourism.service.BusService;
import com.Tourism.Dao.BusDao;
import com.Tourism.DaoImpl.BusDaoImpl;

/**
 * BusServiceImpl class implements the BusService interface and provides
 * the actual logic for performing CRUD operations on Bus entities.
 */
public class BusServiceImpl implements BusService{

	// Instance of BusDao to interact with the data layer
	private BusDao busDao = new BusDaoImpl();

	/**
	 * Adds a new Bus entity to the database.
	 * @param bus The Bus object to be added.
	 */
	@Override
	public void addBus(Bus bus) {
		busDao.add(bus);
	}

	/**
	 * Updates an existing Bus entity in the database.
	 * @param bus The Bus object to be updated.
	 */
	@Override
	public void updateBus(Bus bus) {
		busDao.update(bus);
	}

	/**
	 * Deletes a Bus entity from the database by its ID.
	 * @param id The ID of the Bus to be deleted.
	 */
	@Override
	public void deleteBus(int id) {
		busDao.delete(id);
	}

	/**
	 * Retrieves a Bus entity by its ID.
	 * @param id The ID of the Bus to be retrieved.
	 * @return The Bus entity with the specified ID.
	 */
	@Override
	public Bus getBusById(int id) {
		return busDao.getById(id);
	}

	/**
	 * Retrieves all Bus entities from the database.
	 * @return A list of all Bus entities.
	 */
	@Override
	public List<Bus> getAllBuses() {
		return busDao.getAll();
	}
}

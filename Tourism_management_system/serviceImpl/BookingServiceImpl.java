package com.Tourism.serviceImpl;

import java.util.List;
import com.Tourism.Dao.BookingDao;
import com.Tourism.DaoImpl.BookingDaoImpl;
import com.Tourism.entity.Booking;
import com.Tourism.service.BookingService;

/**
 * BookingServiceImpl class implements the BookingService interface and provides
 * the actual logic for performing CRUD operations on Booking entities.
 */
public class BookingServiceImpl implements BookingService{

	// Instance of BookingDao to interact with the data layer
	private final BookingDao bookingDao = new BookingDaoImpl();

	/**
	 * Adds a new Booking entity to the database.
	 * @param booking The Booking object to be added.
	 */
	@Override
	public void addBooking(Booking booking) {
		bookingDao.add(booking);
	}

	/**
	 * Updates an existing Booking entity in the database.
	 * @param booking The Booking object to be updated.
	 */
	@Override
	public void updateBooking(Booking booking) {
		bookingDao.update(booking);
	}

	/**
	 * Deletes a Booking entity from the database by its ID.
	 * @param id The ID of the Booking to be deleted.
	 */
	@Override
	public void deleteBooking(int id) {
		bookingDao.delete(id);
	}

	/**
	 * Retrieves a Booking entity by its ID.
	 * @param id The ID of the Booking to be retrieved.
	 * @return The Booking entity with the specified ID.
	 */
	@Override
	public Booking getBookingById(int id) {
		return bookingDao.getById(id);
	}

	/**
	 * Retrieves all Booking entities from the database.
	 * @return A list of all Booking entities.
	 */
	@Override
	public List<Booking> getAllBookings() {
		return bookingDao.getAll();
	}
}

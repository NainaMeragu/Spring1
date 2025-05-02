package com.Tourism;

//Importing entity classes
import com.Tourism.entity.Booking;
import com.Tourism.entity.Bus;
import com.Tourism.entity.Feedback;
import com.Tourism.entity.Route;
import com.Tourism.entity.Ticket;
import com.Tourism.entity.User;

//Importing service interfaces
import com.Tourism.service.UserService;
import com.Tourism.service.BookingService;
import com.Tourism.service.BusService;
import com.Tourism.service.RouteService;
import com.Tourism.service.FeedbackService;
import com.Tourism.service.TicketService;

//Importing service implementation classes
import com.Tourism.serviceImpl.UserServiceImpl;
import com.Tourism.serviceImpl.BookingServiceImpl;
import com.Tourism.serviceImpl.BusServiceImpl;
import com.Tourism.serviceImpl.RouteServiceImpl;
import com.Tourism.serviceImpl.FeedbackServiceImpl;
import com.Tourism.serviceImpl.TicketServiceImpl;

//Importing utility classes
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * This class performs all CRUD operations related to Users, Bookings, Bus, Route,
 * Feedback, and Tickets in the Tourism Management System.
 */

/*import com.Tourism.entity.Report;
import com.Tourism.service.ReportService;
import com.Tourism.serviceImpl.ReportServiceImpl;*/

public class AllOperations 
{
	// Creating Service Layer Object Creation
	static UserService userService = new UserServiceImpl();
	static BookingService bookingService = new BookingServiceImpl();
	static BusService busService = new BusServiceImpl();
	static RouteService routeService = new RouteServiceImpl();
	static FeedbackService feedbackService = new FeedbackServiceImpl();
	static TicketService ticketService = new TicketServiceImpl();
	//static ReportService reportService = new ReportServiceImpl();

	// Creating scanner object for user input
	static Scanner sc = new Scanner(System.in);

	// Helper methods for input validation
	// Helper method to safely get integer input
	private static int getIntInput(String prompt) {
		int input = 0;
		while (true) {
			System.out.println(prompt);
			if (sc.hasNextInt()) {
				input = sc.nextInt(); // Read integer input
				break;
			} else {
				System.out.println("Invalid input. Please enter an integer.");
				sc.next(); // Clear/consume invalid input
			}
		}
		return input;
	}

	// Helper method to get String input
	private static String getStringInput(String prompt) {
		sc.nextLine(); // Consume newline left-over //Consume any leftover newline character
		System.out.println(prompt);
		return sc.nextLine(); // Read string input
	}

	// Helper method to get Date input from the user
	private static Date getDateInput(String prompt) {
		while (true) {
			String dateStr = getStringInput(prompt + " (YYYY-MM-DD):");
			try {
				return java.sql.Date.valueOf(dateStr); // Convert String to SQL Date
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid date format. Please use YYYY-MM-DD.");
			}
		}
	}

	// Helper method for taking User input
	public static User userInputs() {
		String userName = getStringInput("Enter User Name:");
		//String userType = getStringInput("Enter UserType:");
		String mobile = getStringInput("Enter Mobile:");
		String email = getStringInput("Enter Email:");
		return new User(userName, mobile, email);
	}

	// Helper method for taking Route input
	public static Route routeInputs() {
		String routeTo = getStringInput("Enter RouteTo:");
		String routeFrom = getStringInput("Enter RouteFrom:");
		String pickUpPoint = getStringInput("Enter pickUpPoint:");
		Date dateOfJourney = getDateInput("Enter dateOfJourney:");
		int busId = getIntInput("Enter Bus ID:");
		Bus bus = busService.getBusById(busId); // Fetch Bus entity
		if (bus == null) {
			System.out.println("Bus with ID " + busId + " not found.");
			return null;
		}
		return new Route(routeTo, routeFrom, pickUpPoint, dateOfJourney, bus);
	}

	// Helper method for taking Ticket input
	public static Ticket ticketInputs() {
		String date = getStringInput("Enter Date:");
		String status = getStringInput("Enter Status:");
		String NumberOfPerson = getStringInput("Enter NumberOfPerson:");
		String Price=getStringInput("Enter Price:");
		int bookingId = getIntInput("Enter Booking ID:");
		Booking booking = bookingService.getBookingById(bookingId);// Fetch Booking entity
		if (booking == null) {
			System.out.println("Booking with ID " + bookingId + " not found.");
			return null;
		}
		int busId = getIntInput("Enter Bus ID:");
		Bus bus = (busId != 0) ? busService.getBusById(busId) : null;  // Fetch Bus entity
		if (busId != 0 && bus == null) {
			System.out.println("Bus with ID " + busId + " not found.");
			return null;
		}
		return new Ticket(date, status, NumberOfPerson, Price, booking, bus);
	}

	// Helper method for taking Feedback input
	public static Feedback feedbackInputs() {
		int rating = getIntInput("Enter Rating:");
		Date date_of_feedback = getDateInput("Enter Date of Feedback");
		int userId = getIntInput("Enter User ID:");
		String userName = getStringInput("Enter User Name:");
		String userEmail = getStringInput("Enter User Email:");
		String experience = getStringInput("Enter User Experience:");
		User user = userService.getUserById(userId);// Fetch User entity
		if (user == null) {
			System.out.println("User with ID " + userId + " not found.");
			return null;
		}
		return new Feedback(rating, userName, userEmail, experience, date_of_feedback, user);
	}

	// Helper method for taking Booking input
	public static Booking bookingInputs() {
		String bookingType = getStringInput("Enter Booking Type:");
		Date bookingDate = getDateInput("Enter Booking Date:");
		String bookingname = getStringInput("Enter bookingname:");
		String routeTo = getStringInput("Enter routeTo:");
		String routeFrom = getStringInput("Enter routeFrom:");
		String pickUpPoint = getStringInput("Enter pickUpPoint:");
		String mobileNo= getStringInput("Enter mobileNo:");
		String email= getStringInput("Enter email:");
		String address= getStringInput("Enter address:");
		int userId = getIntInput("Enter User ID:");
		User user = userService.getUserById(userId);// Fetch User entity
		if (user == null) {
			System.out.println("User with ID " + userId + " not found.");
			return null;
		}
		return new Booking(bookingType, bookingDate, bookingname, routeTo, routeFrom, pickUpPoint, mobileNo, email, address, user);
	}

	// Helper method for taking Bus input
	public static Bus busInputs() {
		String bus_No = getStringInput("Enter Bus_No:");
		String Bus_Type = getStringInput("Enter Bus_Type:");
		String RouteTo= getStringInput("Enter RouteTo:");
		String RouteFrom= getStringInput("Enter RouteFrom:");
		String PickUpPoint= getStringInput("Enter PickUpPoint:");
		return new Bus(bus_No, Bus_Type, RouteTo, RouteFrom, PickUpPoint);
	}

	// CRUD Operations for User Entity
	public static void userOperations() {
		while (true) {
			System.out.println("Press 1. Add User\n2. View All Users\n3. Update User\n4. Delete User\n5. Back to Main Menu");
			int choice = getIntInput("Enter choice:");
			switch (choice) {
			case 1:
				// Adding new user
				User user = userInputs();
				if (user != null) {
					userService.addUser(user);
					System.out.println("User added successfully.");
				}
				break;
			case 2:
				// Viewing all users
				userService.getAllUsers().forEach(System.out::println);
				break;
			case 3:
				// Updating existing user
				int userId = getIntInput("Enter User ID to update:");
				User userUpdate = userInputs();
				if (userUpdate != null) {
					userUpdate.setUserId(userId);
					userService.updateUser(userUpdate);
					System.out.println("User updated successfully.");
				}
				break;
			case 4:
				// Deleting a user
				userId = getIntInput("Enter User ID to delete:");
				userService.deleteUser(userId);
				System.out.println("User deleted successfully.");
				break;
			case 5:
				// Returning to main menu
				return;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	// CRUD Operations for Route Entity
	public static void routeOperations() {
		while (true) {
			System.out.println("Press 1. Add Route\n2. View All Routes\n3. Update Route\n4. Delete Route\n5. Back to Main Menu");
			int choice = getIntInput("Enter choice:");
			switch (choice) {
			case 1:
				// Adding new route
				Route route = routeInputs();
				if (route != null) {
					routeService.addRoute(route);
					System.out.println("Route added successfully.");
				}
				break;
			case 2:
				// Viewing all routes
				routeService.getAllRoutes().forEach(System.out::println);
				break;
			case 3:
				// Updating existing route
				int routeId = getIntInput("Enter Route ID to update:");
				Route routeUpdate = routeInputs();
				if (routeUpdate != null) {
					routeUpdate.setRouteId(routeId);
					routeService.updateRoute(routeUpdate);
					System.out.println("Route updated successfully.");
				}
				break;
			case 4:
				// Deleting a route
				routeId = getIntInput("Enter Route ID to delete:");
				routeService.deleteRoute(routeId);
				System.out.println("Route deleted successfully.");
				break;
			case 5:
				// Returning to main menu
				return;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	// CRUD Operations for Ticket Entity
	public static void ticketOperations() {
		while (true) {
			// Infinite loop for menu-driven ticket operations
			System.out.println("Press 1. Add Ticket\n2. View All Ticket\n3. Update Ticket\n4. Delete Ticket\n5. Back to Main Menu");
			int choice = getIntInput("Enter choice:"); // Taking user choice
			switch (choice) {
			// Switch case based on user's choice
			case 1:
				Ticket ticket = ticketInputs(); // Get ticket input from user
				if (ticket != null) {
					ticketService.addTicket(ticket); // Add ticket to database
					System.out.println("Ticket added successfully.");
				}
				break;
			case 2:
				ticketService.getAllTickets().forEach(System.out::println); // Display all tickets
				break;
			case 3:
				int ticketId = getIntInput("Enter Ticket ID to update:");// Get ticket ID to update
				Ticket ticketUpdate = ticketInputs(); // Get updated ticket data
				if (ticketUpdate != null) {
					ticketUpdate.setTicket_ID(ticketId); // Set the ticket ID to update
					ticketService.updateTicket(ticketUpdate); // Update ticket in database
					System.out.println("Ticket updated successfully.");
				}
				break;
			case 4:
				ticketId = getIntInput("Enter Ticket ID to delete:"); // Get ticket ID to delete
				ticketService.deleteTicket(ticketId); // Delete ticket from database
				System.out.println("Ticket deleted successfully.");
				break;
			case 5:
				return;// Exit from ticket operations menu
			default:
				System.out.println("Invalid choice.");// Handle invalid choice
			}
		}
	}

	// CRUD Operations for Feedback Entity
	public static void feedbackOperations() {
		while (true) {
			// Infinite loop for feedback operations
			System.out.println("Press 1. Add Feedback\n2. View All Feedbacks\n3. Update Feedback\n4. Delete Feedback\n5. Back to Main Menu");
			int choice = getIntInput("Enter choice:");// Take user's choice
			switch (choice) { // Switch case based on user's choice
			case 1:
				Feedback feedback = feedbackInputs();// Get feedback input from user
				if (feedback != null) {
					feedbackService.addFeedback(feedback);// Add feedback to database
					System.out.println("Feedback added successfully.");
				}
				break;
			case 2:
				feedbackService.getAllFeedbacks().forEach(System.out::println);// Display all feedbacks
				break;
			case 3:
				int feedbackId = getIntInput("Enter Feedback ID to update:");// Get feedback ID to update
				Feedback feedbackUpdate = feedbackInputs();// Get updated feedback data
				if (feedbackUpdate != null) {
					feedbackUpdate.setFeedback_ID(feedbackId);// Set feedback ID to update.updateFeedback(feedbackUpdate);
					System.out.println("Feedback updated successfully.");// Update feedback in database
				}
				break;
			case 4:
				feedbackId = getIntInput("Enter Feedback ID to delete:");// Get feedback ID to delete
				feedbackService.deleteFeedback(feedbackId);// Delete feedback from database
				System.out.println("Feedback deleted successfully.");
				break;
			case 5:
				return;// Exit from feedback operations menu
			default:
				System.out.println("Invalid choice.");// Handle invalid choice
			}
		}
	}
}

// CRUD Operations for Booking Entity
public static void bookingOperations() {
	while (true) {
		// Infinite loop for booking operations
		System.out.println("Press 1. Add Booking\n2. View All Bookings\n3. Update Booking\n4. Delete Booking\n5. Back to Main Menu");
		int choice = getIntInput("Enter choice:");// Take user's choice
		switch (choice) {// Switch case based on user's choice
		case 1:
			Booking booking = bookingInputs();// Get booking input from user
			if (booking != null) {
				bookingService.addBooking(booking);// Add booking to database
				System.out.println("Booking added successfully.");
			}
			break;
		case 2:
			bookingService.getAllBookings().forEach(System.out::println);// Display all bookings
			break;
		case 3:
			int bookingId = getIntInput("Enter Booking ID to update:");// Get booking ID to update
			Booking bookingUpdate = bookingInputs();// Get updated booking data
			if (bookingUpdate != null) {
				bookingUpdate.setBookingId(bookingId);// Set booking ID to update
				bookingService.updateBooking(bookingUpdate);// Update booking in database
				System.out.println("Booking updated successfully.");
			}
			break;
		case 4:
			bookingId = getIntInput("Enter Booking ID to delete:");// Get booking ID to delete
			bookingService.deleteBooking(bookingId);// Delete booking from database
			System.out.println("Booking deleted successfully.");
			break;
		case 5:
			return;// Exit from booking operations menu
		default:
			System.out.println("Invalid choice.");// Handle invalid choice
		}
	}
}

// CRUD Operations for Bus Entity
public static void busOperations() {
	while (true) {// Infinite loop for bus operations
		System.out.println("Press 1. Add Bus\n2. View All Buses\n3. Update Bus\n4. Delete Bus\n5. Back to Main Menu");
		int choice = getIntInput("Enter choice:");// Take user's choice
		switch (choice) {// Switch case based on user's choice
		case 1:
			Bus bus = busInputs();// Get bus input from user
			if (bus != null) {
				busService.addBus(bus);// Add bus to database
				System.out.println("Bus added successfully.");
			}
			break;
		case 2:
			busService.getAllBuses().forEach(System.out::println);// Display all buses
			break;
		case 3:
			int busId = getIntInput("Enter Bus ID to update:");// Get bus ID to update
			Bus busUpdate = busInputs();// Get updated bus data
			if (busUpdate != null) {
				busUpdate.setBus_ID(busId);// Set bus ID to update
				busService.updateBus(busUpdate);// Update bus in database
				System.out.println("Bus updated successfully.");
			}
			break;
		case 4:
			busId = getIntInput("Enter Bus ID to delete:");// Get bus ID to delete
			busService.deleteBus(busId);// Delete bus from database
			System.out.println("Bus deleted successfully.");
			break;
		case 5:
			return;// Exit from bus operations menu
		default:
			System.out.println("Invalid choice.");// Handle invalid choice
		}
	}
}

// Retrieve all Tickets based on Booking ID
public static List<Ticket> getTicketByBooking() {
	int bookingId = getIntInput("Enter Booking ID:");
	return ticketService.getAllTickets().stream()
			.filter(b -> b.getBooking().getBookingId() == bookingId)
			.toList(); // Returning list of tickets related to booking
}


/*public static Report reportInputs() {
	String reportName = getStringInput("Enter Report Name:");
	String reportType = getStringInput("Enter Report Type:");
	return new Report(reportName, reportType);
}*/

/*public static void reportOperations() {
	while (true) {
		System.out.println("Press 1. Add Report\n2. View All Reports\n3. Update Report\n4. Delete Report\n5. Back to Main Menu");
		int choice = getIntInput("Enter choice:");
		switch (choice) {
		case 1:
			Report report = reportInputs();
			if (report != null) {
				reportService.addReport(report);
				System.out.println("Report added successfully.");
			}
			break;
		case 2:
			reportService.getAllReports().forEach(System.out::println);
			break;
		case 3:
			int reportId = getIntInput("Enter Report ID to update:");
			Report reportUpdate = reportInputs();
			if (reportUpdate != null) {
				reportUpdate.setReportId(reportId);
				reportService.updateReport(reportUpdate);
				System.out.println("Report updated successfully.");
			}
			break;
		case 4:
			reportId = getIntInput("Enter Report ID to delete:");
			reportService.deleteReport(reportId);
			System.out.println("Report deleted successfully.");
			break;
		case 5:
			return;
		default:
			System.out.println("Invalid choice.");
		}
	}
}*/
}
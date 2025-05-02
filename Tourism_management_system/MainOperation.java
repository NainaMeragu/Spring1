package com.Tourism;

import java.util.List;
import java.util.Scanner;
import com.Tourism.entity.Ticket;

/**
 * MainOperation class serves as the entry point for the Tourism Management System application.
 * It displays the main menu and handles user interaction.
 */
public class MainOperation {

	// Scanner object for user input
	static Scanner sc = new Scanner(System.in);

	/**
	 * Displays the main menu and handles user choices for different operations.
	 */
	public static void mainOps() {
		// Infinite loop to keep showing the menu until the user exits
		while (true) {
			// Displaying main menu options
			System.out.println("\n=== Tourism Management System ===");
			System.out.println("Press 1. User Details");
			System.out.println("Press 2. Bus Details");
			System.out.println("Press 3. To Provide Feedback ");
			System.out.println("Press 4. Book Ticket ");
			System.out.println("Press 5. Booking Details");
			System.out.println("Press 6. Route Details");
			//System.out.println("Press 7. Report Details");
			System.out.println("Press 7. To Check All Ticket Based On Booking");
			System.out.println("Press 8. Quit");

			int input = sc.nextInt(); // Taking user input

			// Handling user's choice using switch-case
			switch (input) {
			case 1:
				AllOperations.userOperations(); // Calling user operations
				System.out.println("=======================================");
				break;
			case 2:
				AllOperations.busOperations(); // Calling bus operations
				System.out.println("=======================================");
				break;
			case 3:
				AllOperations.feedbackOperations(); // Calling feedback operations
				System.out.println("=======================================");
				break;
			case 4:
				AllOperations.ticketOperations(); // Calling ticket booking operations
				System.out.println("=======================================");
				break;
			case 5:
				AllOperations.bookingOperations(); // Calling booking operations
				System.out.println("=======================================");
				break;
			case 6:
				AllOperations.routeOperations(); // Calling route operations
				System.out.println("=======================================");
				break;
				/*case 7:
                    AllOperations.reportOperations(); // Calling report operations
                    System.out.println("=======================================");
                    break;*/
			case 7:
				List<Ticket> ticketList = AllOperations.getTicketByBooking(); // Fetching and displaying all tickets based on booking
				for (Ticket ticket : ticketList) {
					System.out.println(ticket); // Display each ticket
				}
				System.out.println("=======================================");
				break;
			case 8:
				System.exit(0); // Exiting the application
			default:
				System.out.println("Wrong input"); // Handling invalid input
			}
		}
	}

	/**
	 * Main method to start the application.
	 *
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		mainOps(); // Calling mainOps method to start the menu-driven program
	}
}
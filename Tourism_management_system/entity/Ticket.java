package com.Tourism.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Represents a Ticket entity in the Tourism Management System.

@Entity
@Table(name = "tickets")
public class Ticket {

	// Primary key for the Ticket table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Ticket_ID;

	// Date of travel or booking
	private String date;

	// Status of the ticket (e.g., Confirmed, Cancelled)
	private String status;

	// Number of persons this ticket is booked for
	private String NumberOfPerson;

	// Price of the ticket
	private String Price;

	// Many tickets are belong/linked to one booking.
	@ManyToOne
	@JoinColumn(name = "booking_id", nullable = false)
	private Booking booking;

	// Many tickets are associated with one bus.
	@ManyToOne
	@JoinColumn(name = "bus_id", nullable = false)
	private Bus bus;


	// ✅ Add Default Constructor (Required by Hibernate)
	public Ticket() {
	}

	// ✅ Parameterized Constructor for easier object creation
	public Ticket(String date, String status, String numberOfPerson, String price, Booking booking, Bus bus) {
		super();
		this.date = date;
		this.status = status;
		NumberOfPerson = numberOfPerson;
		Price = price;
		this.booking = booking;
		this.bus = bus;
	}

	// ✅ Getters and Setters
	public int getTicket_ID() {
		return Ticket_ID;
	}

	public void setTicket_ID(int ticket_ID) {
		Ticket_ID = ticket_ID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNumberOfPerson() {
		return NumberOfPerson;
	}

	public void setNumberOfPerson(String numberOfPerson) {
		NumberOfPerson = numberOfPerson;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	// toString method excluding nested entities to avoid stack overflow
	@Override
	public String toString() {
		return "Ticket [Ticket_ID=" + Ticket_ID + ", date=" + date + ", status=" + status + ", NumberOfPerson="
				+ NumberOfPerson + ", Price=" + Price + ", booking=" + booking + ", bus=" + bus + "]";
	}

	/*@Override
	public String toString() {
		return "Ticket [Ticket_ID=" + Ticket_ID + ", date=" + date + ", status=" + status + ", booking=" + booking
				+ ", bus=" + bus + "]";
	}*/ 
}

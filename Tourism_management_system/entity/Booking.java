package com.Tourism.entity;

import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

// Represents the Booking entity storing booking information and its relationship with User and Ticket entities.

@Entity
@Table(name = "booking")
public class Booking {

	// Primary key for the booking table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "Booking_ID")
	private int bookingId;

	// Type of booking (Offline)
	@Column(name = "Booking_Type", length = 50, nullable = false)
	private String bookingType;

	// Name of the person booking
	@Column(name = "Booking_name", length=100)
	private String bookingname;

	// Destination place
	@Column(name = "Route_To")
	private String routeTo;

	// Origin place
	@Column(name = "Route_From")
	private String routeFrom;

	// Pick-up location for the journey
	@Column(name = "Pick_Up_Point")
	private String pickUpPoint;

	// Mobile number of the user
	@Column(name = "MobileNo", length = 15)
	private String mobileNo;

	// Email address of the user
	@Column(name = "Email", length = 100)
	private String email;

	// Residential address of the user
	@Column(name = "Address", length = 100)
	private String address;

	// Date of booking
	@Temporal(TemporalType.DATE)
	@Column(name = "Date", nullable = false)
	private Date bookingDate;

	// Many bookings belong to one user.
	@ManyToOne
	@JoinColumn(name = "User_ID", nullable = false)
	private User user;

	// A booking can have multiple tickets associated with it.
	@OneToMany(mappedBy = "booking", fetch = FetchType.EAGER)//cascade = CascadeType.ALL)
	private List<Ticket> tickets;

	// ✅ Default Constructor
	public Booking() {
	}

	// ✅ Parameterized Constructor
	public Booking(String bookingType, Date bookingDate, String bookingname, String mobileNo, String email, String address, String routeTo, String routeFrom, String pickUpPoint, User user) {
		super();
		this.bookingType = bookingType;
		this.bookingDate = bookingDate;
		this.bookingname = bookingname;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.routeTo = routeTo;
		this.routeFrom = routeFrom;
		this.pickUpPoint = pickUpPoint;
		this.user = user;
	}

	// ✅ Getters and Setters
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBookingname() {
		return bookingname;
	}

	public void setBookingname(String bookingname) {
		this.bookingname = bookingname;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getPickUpPoint() {
		return pickUpPoint;
	}

	public void setPickUpPoint(String pickUpPoint) {
		this.pickUpPoint = pickUpPoint;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	// ✅ toString() method for logging/debugging
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingType=" + bookingType + ", bookingDate=" + bookingDate + ", bookingname=" + bookingname
				+ ", mobileNo=" + mobileNo + ", email=" + email + ", address=" + address + ", routeTo=" + routeTo + ", routeFrom=" + routeFrom + ", pickUpPoint=" + pickUpPoint
				+ ", user=" + user + "]";
	}
}
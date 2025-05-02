package com.Tourism.entity;

import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* Represents a User in the Tourism Management System.*/
@Entity
@Table(name = "users")
public class User {

	// Primary key for the User table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	private int userId;

	// Name of the user (not null, max length 100)
	@Column(name = "User_Name", nullable = false, length = 100)
	private String userName;

	/*@Column(name = "User_Type", length = 50)
	private String userType;*/

	// Mobile number of the user (max length 15)
	@Column(name = "Mobile", length = 15)
	private String mobile;

	// Email address of the user (max length 100)
	@Column(name = "Email", length = 100)
	private String email;

	// A user can have multiple bookings.(Eager fetch for immediate loading)
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)//cascade = CascadeType.ALL)
	private List<Booking> bookings;

	// A user can provide multiple feedbacks.(Cascade all operations)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Feedback> feedbacks;

	// ✅ Default Constructor required by JPA
	public User() {
	}

	// ✅ Parameterized Constructor to create User instances quickly
	public User(String userName, String mobile, String email) {
		super();
		this.userName = userName;
		//String userType
		//this.userType = userType;
		this.mobile = mobile;
		this.email = email;
	}

	// ✅ Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}*/

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	// toString method without printing collections to avoid stack overflow
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", mobile=" + mobile
				+ ", email=" + email + "]";
	}
	//userType=" + userType + "

	/*@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}*/		
}
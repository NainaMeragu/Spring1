package com.Tourism.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

// Represents a Feedback entity where users share their experience and ratings.

@Entity
@Table(name="feedbacks")
public class Feedback {

	// Primary key for the feedbacks table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Feedback_ID")
	private int Feedback_ID;

	// Rating provided by the user
	@Column(name = "Rating")
	private int Rating;

	// Name of the user giving feedback
	@Column(name = "user_name")
	private String userName;

	// Email of the user giving feedback
	@Column(name = "user_email")
	private String userEmail;

	// Experience description provided by the user
	@Column(name = "experience", length = 500)
	private String experience;

	// Date when feedback was given
	@Column(name = "date_of_feedback")
	@Temporal(TemporalType.DATE)
	private Date date_of_feedback;

	// Many feedback are associated/belong with/to one user.
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// ✅ Default Constructor (required by Hibernate)
	public Feedback() {
	}

	// ✅ Parameterized Constructor
	public Feedback(int rating, String userName, String userEmail, String experience, Date date_of_feedback,
			User user) {
		super();
		Rating = rating;
		this.userName = userName;
		this.userEmail = userEmail;
		this.experience = experience;
		this.date_of_feedback = date_of_feedback;
		this.user = user;
	}

	public int getFeedback_ID() {
		return Feedback_ID;
	}

	public void setFeedback_ID(int feedback_ID) {
		Feedback_ID = feedback_ID;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Date getDate_of_feedback() {
		return date_of_feedback;
	}

	public void setDate_of_feedback(Date date_of_feedback) {
		this.date_of_feedback = date_of_feedback;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// ✅ toString() method for easy logging/debugging
	@Override
	public String toString() {
		return "Feedback [Feedback_ID=" + Feedback_ID + ", Rating=" + Rating + ", userName=" + userName + ", userEmail="
				+ userEmail + ", experience=" + experience + ", date_of_feedback=" + date_of_feedback + ", user=" + user
				+ "]";
	}
}
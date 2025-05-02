package com.Tourism.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

// Represents a Route entity in the Tourism Management System.

@Entity
@Table(name = "routes")
public class Route {

	// Primary key for the Route table
	@Id
	@Column(name = "Route_ID")
	private int routeId;

	// Destination of the route
	@Column(name = "Route_To")
	private String routeTo;

	// Starting location of the route
	@Column(name = "Route_From")
	private String routeFrom;

	// Pick-up point for passengers
	@Column(name = "Pick_Up_Point")
	private String pickUpPoint;

	// Date of the journey
	@Temporal(TemporalType.DATE)
	@Column(name = "Date_Of_Journey")
	private Date dateOfJourney;

	// Many routes are associated with one bus.
	// Many routes are assigned to one bus
	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;

	// ✅ Default Constructor (required by Hibernate)
	public Route() {
	}

	// ✅ Parameterized Constructor for easier object creation
	public Route(String routeTo, String routeFrom, String pickUpPoint, Date dateOfJourney, Bus bus) {
		super();
		this.routeTo = routeTo;
		this.routeFrom = routeFrom;
		this.pickUpPoint = pickUpPoint;
		this.dateOfJourney = dateOfJourney;
		this.bus = bus;
	}

	// ✅ Getters and Setters
	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
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

	public Date getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	// toString() method that avoids recursion by only printing bus ID
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeTo=" + routeTo + ", routeFrom=" + routeFrom + ", pickUpPoint="
				+ pickUpPoint + ", dateOfJourney=" + dateOfJourney + ", bus=" + bus + "]";
	} 
}

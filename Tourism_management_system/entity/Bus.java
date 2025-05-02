package com.Tourism.entity;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// Represents the Bus entity storing bus details and its relationship with tickets and routes.

@Entity
@Table(name = "buses")
public class Bus {

	// Primary key for the buses table
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Bus_ID")
	private int Bus_ID;

	// Bus number (unique identifier for buses)
	@Column(name = "Bus_No")
	private String Bus_No;

	// Type of the bus (e.g., AC, Non-AC, Sleeper)
	@Column(name = "Bus_Type")
	private String Bus_Type;

	// Destination city or place
	@Column(name = "Route_To")
	private String routeTo;

	// Starting city or place
	@Column(name = "Route_From")
	private String routeFrom;

	// Pick-up point for the bus
	@Column(name = "Pick_Up_Point")
	private String pickUpPoint;

	/*@Column(name = "Total_Seats", length=100)
    private Integer Total_Seats = 100;*/

	// A bus can have multiple tickets associated with it.
	@OneToMany(mappedBy = "bus", fetch = FetchType.EAGER)//cascade = CascadeType.ALL)
	private List<Ticket> tickets;

	// A bus can have multiple routes associated.
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
	private List<Route> routes;

	// ✅ Default Constructor (required by Hibernate)
	public Bus() {
	}

	// ✅ Parameterized Constructor
	public Bus(String bus_No, String bus_Type, String routeTo, String routeFrom, String pickUpPoint) {
		super();
		Bus_No = bus_No;
		Bus_Type = bus_Type;
		this.routeTo = routeTo;
		this.routeFrom = routeFrom;
		this.pickUpPoint = pickUpPoint;
	}

	// ✅ Getters and Setters
	public int getBus_ID() {
		return Bus_ID;
	}

	public void setBus_ID(int bus_ID) {
		Bus_ID = bus_ID;
	}

	public String getBus_No() {
		return Bus_No;
	}

	public void setBus_No(String bus_No) {
		Bus_No = bus_No;
	}

	public String getBus_Type() {
		return Bus_Type;
	}

	public void setBus_Type(String bus_Type) {
		Bus_Type = bus_Type;
	}

	/*public int getTotal_Seats() {
		return Total_Seats;
	}

	public void setTotal_Seats(int total_Seats) {
		Total_Seats = total_Seats;
	}*/

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

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	// ✅ toString() method for logging/debugging
	@Override
	public String toString() {
		return "Bus [Bus_ID=" + Bus_ID + ", Bus_No=" + Bus_No + ", Bus_Type=" + Bus_Type + ", routeTo=" + routeTo
				+ ", routeFrom=" + routeFrom + ", pickUpPoint=" + pickUpPoint + "]";
	}

	/*@Override
	public String toString() {
		return "Bus [Bus_ID=" + Bus_ID + ", Bus_No=" + Bus_No + ", Bus_Type=" + Bus_Type + "]";
	}*/

}
package com.google.location.track.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Leg {
	private Distance distance;
	private Duration duration;
	private String end_address;
	private End_location end_location;
	private String start_address;
	private Start_location start_location;
	private Step steps[];
	private Traffic_speed_entry traffic_speed_entry[];
	private Via_waypoint via_waypoint[];

	public Distance getDistance() {
		return distance;
	}

	public void setDistance(Distance distance) {
		this.distance = distance;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public String getEnd_address() {
		return end_address;
	}

	public void setEnd_address(String end_address) {
		this.end_address = end_address;
	}

	public End_location getEnd_location() {
		return end_location;
	}

	public void setEnd_location(End_location end_location) {
		this.end_location = end_location;
	}

	public String getStart_address() {
		return start_address;
	}

	public void setStart_address(String start_address) {
		this.start_address = start_address;
	}

	public Start_location getStart_location() {
		return start_location;
	}

	public void setStart_location(Start_location start_location) {
		this.start_location = start_location;
	}

	public Step[] getSteps() {
		return steps;
	}

	public void setSteps(Step[] steps) {
		this.steps = steps;
	}

	public Traffic_speed_entry[] getTraffic_speed_entry() {
		return traffic_speed_entry;
	}

	public void setTraffic_speed_entry(Traffic_speed_entry[] traffic_speed_entry) {
		this.traffic_speed_entry = traffic_speed_entry;
	}

	public Via_waypoint[] getVia_waypoint() {
		return via_waypoint;
	}

	public void setVia_waypoint(Via_waypoint[] via_waypoint) {
		this.via_waypoint = via_waypoint;
	}

}

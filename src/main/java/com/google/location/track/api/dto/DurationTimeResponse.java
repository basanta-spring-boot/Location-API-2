package com.google.location.track.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DurationTimeResponse {
	private Geocoded_waypoint geocoded_waypoints[];
	private Route routes[];
	private String status;

	public Geocoded_waypoint[] getGeocoded_waypoints() {
		return geocoded_waypoints;
	}

	public void setGeocoded_waypoints(Geocoded_waypoint[] geocoded_waypoints) {
		this.geocoded_waypoints = geocoded_waypoints;
	}

	public Route[] getRoutes() {
		return routes;
	}

	public void setRoutes(Route[] routes) {
		this.routes = routes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

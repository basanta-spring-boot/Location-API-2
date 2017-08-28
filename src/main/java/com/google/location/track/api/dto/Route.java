package com.google.location.track.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Route {
	private Bounds bounds;
	private String copyrights;
	private Leg legs[];
	private Overview_polyline overview_polyline;
	private String summary;
	private Warning warnings[];
	private Waypoint_order waypoint_order[];

	public Bounds getBounds() {
		return bounds;
	}

	public void setBounds(Bounds bounds) {
		this.bounds = bounds;
	}

	public String getCopyrights() {
		return copyrights;
	}

	public void setCopyrights(String copyrights) {
		this.copyrights = copyrights;
	}

	public Leg[] getLegs() {
		return legs;
	}

	public void setLegs(Leg[] legs) {
		this.legs = legs;
	}

	public Overview_polyline getOverview_polyline() {
		return overview_polyline;
	}

	public void setOverview_polyline(Overview_polyline overview_polyline) {
		this.overview_polyline = overview_polyline;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Warning[] getWarnings() {
		return warnings;
	}

	public void setWarnings(Warning[] warnings) {
		this.warnings = warnings;
	}

	public Waypoint_order[] getWaypoint_order() {
		return waypoint_order;
	}

	public void setWaypoint_order(Waypoint_order[] waypoint_order) {
		this.waypoint_order = waypoint_order;
	}

}

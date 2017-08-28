package com.google.location.track.api.dto;

public class DurationTimeWrapper {
	private String distance;
	private String duration;

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public DurationTimeWrapper(String distance, String duration) {
		super();
		this.distance = distance;
		this.duration = duration;
	}

	public DurationTimeWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

}

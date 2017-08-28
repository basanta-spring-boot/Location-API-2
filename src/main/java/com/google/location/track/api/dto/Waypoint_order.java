package com.google.location.track.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Waypoint_order {
	@JsonCreator
	public Waypoint_order() {
	}
}

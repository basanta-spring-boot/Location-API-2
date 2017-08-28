package com.google.location.track.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Traffic_speed_entry {
	@JsonCreator
	public Traffic_speed_entry() {
	}
}

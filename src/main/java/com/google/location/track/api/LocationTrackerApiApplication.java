package com.google.location.track.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class LocationTrackerApiApplication extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/Location-Tracker-API").setViewName("home");
		registry.addViewController("/getAddress").setViewName("getAddress");
		registry.addViewController("/getDuration").setViewName("getDuration");
		registry.addViewController("/getLatLang").setViewName("getLatLang");
		registry.addViewController("/viewSearchPlace").setViewName(
				"searchPlace");

	}

	public static void main(String[] args) {
		SpringApplication.run(LocationTrackerApiApplication.class, args);
	}
}

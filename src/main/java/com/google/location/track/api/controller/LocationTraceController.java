package com.google.location.track.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.location.track.api.common.Constants;
import com.google.location.track.api.dto.DurationTimeWrapper;
import com.google.location.track.api.dto.Location;
import com.google.location.track.api.dto.LocationResponse;
import com.google.location.track.api.search.dto.NearestSearchResponse;
import com.google.location.track.api.util.PdfGenaratorUtil;
import com.google.location.track.api.util.RuleUtil;

@Controller
@RequestMapping(value = "/GMap")
public class LocationTraceController {
	@Autowired
	private RuleUtil ruleUtil;

	@Autowired
	private PdfGenaratorUtil util;

	private Logger logger = LoggerFactory
			.getLogger(LocationTraceController.class);

	private static List<NearestSearchResponse> searchResponses = null;

	@RequestMapping(value = "/getLocation")
	public String getAddress(@RequestParam("lattitude") double lattitude,
			@RequestParam("longitude") double longitude, Model model) {
		LocationResponse response = null;
		logger.debug(
				"getAddress() method called with lattitude {} and longitude {}",
				lattitude, longitude);
		try {
			response = ruleUtil.getAddressDetails(lattitude, longitude);
			logger.info("Response in Controller for getAddress API: {}",
					new ObjectMapper().writeValueAsString(response));
			String address = response.getResults().get(0).getFormattedAddress();
			model.addAttribute("address", address);
		} catch (Exception e) {
			model.addAttribute("errorMessage", Constants.ERROR_MESSAGE);
			logger.error("Error in Controller : {}", e.getMessage());
		}
		return "getAddress";
	}

	@RequestMapping(value = "/getDistanceTime")
	public String getDistanceTime(String source, String destination, Model model) {
		DurationTimeWrapper response = null;
		logger.debug(
				"getDistanceTime() method called with source {} and destination {}",
				source, destination);
		try {
			response = ruleUtil.getDuration(source, destination);
			logger.info("Response in Controller for getDistanceTime API: {}",
					new ObjectMapper().writeValueAsString(response));
			model.addAttribute("response", response);
		} catch (Exception e) {
			model.addAttribute("errorMessage", Constants.ERROR_MESSAGE);
			logger.error("Error in Controller : {}", e.getMessage());
		}
		return "getDuration";

	}

	@RequestMapping(value = "/getLatitudeLongitude")
	public String getLatitudeLongitude(String address, Model model) {
		Location location = null;
		logger.debug("getLatitudeLongitude() method called with address {} ",
				address);
		try {
			location = ruleUtil.getLatitudeLongitude(address);
			logger.info(
					"Response in Controller for getLatitudeLongitude API: {}",
					new ObjectMapper().writeValueAsString(location));
			model.addAttribute("location", location);
		} catch (Exception e) {
			model.addAttribute("errorMessage", Constants.ERROR_MESSAGE);
			logger.error("Error in Controller : {}", e.getMessage());
		}
		return "getLatLang";
	}

	@RequestMapping(value = "/searchNearestPlace")
	public String getNearestPlace(
			@RequestParam("searchType") String searchType,
			@RequestParam("location") String location, Model model) {
		int matchesCount = 0;
		logger.debug(
				"getNearestPlace() method called with searchType {}  and location {} ",
				searchType, location);
		try {
			searchResponses = ruleUtil.getNearestPlace(searchType, location);
			matchesCount = searchResponses.size();
			logger.info("Response in Controller for getNearestPlace API: {}",
					new ObjectMapper().writeValueAsString(searchResponses));
			model.addAttribute("matchesCount", matchesCount);
			model.addAttribute("searchResponses", searchResponses);
		} catch (Exception e) {
			model.addAttribute("errorMessage", Constants.ERROR_MESSAGE);
			logger.error("Error in Controller : {}", e.getMessage());
		}
		return "searchResault";

	}

	@RequestMapping("/generatePDF")
	public String generatePDF(Model model) {
		int matchesCount = 0;
		Map<Object, Object> data = new HashMap<>();
		data.put("searchResponses", searchResponses);
		try {
			matchesCount = searchResponses.size();
			model.addAttribute("matchesCount", matchesCount);
			util.createPdf("report", data);
			model.addAttribute("message", "Downloaded successfully..");
		} catch (Exception e) {
			model.addAttribute("errorMessage", Constants.ERROR_MESSAGE);
			logger.error(e.getLocalizedMessage());
		}
		return "searchResault";
	}
}

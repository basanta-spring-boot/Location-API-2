package com.google.location.track.api.util;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.location.track.api.common.Constants;
import com.google.location.track.api.dto.DurationTimeResponse;
import com.google.location.track.api.dto.DurationTimeWrapper;
import com.google.location.track.api.dto.Location;
import com.google.location.track.api.dto.LocationResponse;
import com.google.location.track.api.search.dto.NearestSearchResponse;
import com.google.location.track.api.search.dto.SearchResponse;

@Component
@PropertySource(value = { "classpath:googleMap.properties" })
public class RuleUtil {

	@Autowired
	private Environment environment;
	private RestTemplate template;
	ObjectMapper mapper = null;
	HttpHeaders headers = null;

	private static String API_KEY = "";
	private static String URL = "";

	@PostConstruct
	public void init() {
		template = new RestTemplate();
		mapper = new ObjectMapper();
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		template.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		template.getMessageConverters().add(new StringHttpMessageConverter());
	}

	public LocationResponse getAddressDetails(double lat, double lan)
			throws JsonParseException, JsonMappingException, IOException {
		API_KEY = environment.getProperty(Constants.GET_ADDRESS_API_KEY);
		URL = environment.getProperty(Constants.GET_ADDRESS_URL) + lat
				+ Constants.COMMA_SEPARATOR + lan + Constants.KEY_CONSTANT
				+ API_KEY;
		String result = template.getForObject(URL, String.class);
		LocationResponse response = mapper.readValue(result,
				LocationResponse.class);
		return response;
	}

	public DurationTimeWrapper getDuration(String source, String destination)
			throws JsonParseException, JsonMappingException, IOException {
		API_KEY = environment.getProperty(Constants.GET_DURATION_API_KEY);
		URL = environment.getProperty(Constants.GET_DURATION_URL) + source
				+ Constants.COMMA_SEPARATOR + Constants.DESTINATION_CONSTANT
				+ destination + Constants.KEY_CONSTANT + API_KEY;
		String result = template.getForObject(URL, String.class);
		DurationTimeResponse response = mapper.readValue(result,
				DurationTimeResponse.class);
		return ServiceUtils.getDetails(response);

	}

	public Location getLatitudeLongitude(String address)
			throws JsonParseException, JsonMappingException, IOException {
		API_KEY = environment.getProperty(Constants.GET_LATLANG_API_KEY);
		URL = environment.getProperty(Constants.GET_LATLANG_URL) + address
				+ Constants.KEY_CONSTANT + API_KEY;
		String result = template.getForObject(URL, String.class);
		LocationResponse response = mapper.readValue(result,
				LocationResponse.class);
		Location location = response.getResults().get(0).getGeometry()
				.getLocation();
		return location;
	}

	public List<NearestSearchResponse> getNearestPlace(String searchType,
			String location) throws JsonParseException, JsonMappingException,
			IOException {
		API_KEY = environment.getProperty(Constants.GET_NEAREST_PLACE_API_KEY);
		URL = environment.getProperty(Constants.GET_NEAREST_PLACE_URL)
				+ searchType + "+in+" + location + Constants.KEY_CONSTANT
				+ API_KEY;
		String result = template.getForObject(URL, String.class);
		SearchResponse response = mapper
				.readValue(result, SearchResponse.class);
		return ServiceUtils.getSearchInfo(response, searchType);
	}

}

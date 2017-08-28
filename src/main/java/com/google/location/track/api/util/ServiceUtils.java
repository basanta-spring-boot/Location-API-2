package com.google.location.track.api.util;

import java.util.ArrayList;
import java.util.List;

import com.google.location.track.api.dto.DurationTimeResponse;
import com.google.location.track.api.dto.DurationTimeWrapper;
import com.google.location.track.api.dto.Leg;
import com.google.location.track.api.search.dto.NearestSearchResponse;
import com.google.location.track.api.search.dto.Result;
import com.google.location.track.api.search.dto.SearchResponse;

public class ServiceUtils {

	public static DurationTimeWrapper getDetails(DurationTimeResponse response) {
		DurationTimeWrapper wrapperResponse = null;
		Leg[] legs = response.getRoutes()[0].getLegs();
		for (Leg leg : legs) {
			wrapperResponse = new DurationTimeWrapper(leg.getDistance()
					.getText(), leg.getDuration().getText());
		}
		return wrapperResponse;

	}

	public static List<NearestSearchResponse> getSearchInfo(
			SearchResponse response, String searchType) {
		List<NearestSearchResponse> searchList = new ArrayList<>();
		NearestSearchResponse searchResponse = null;
		List<Result> results = response.getResults();
		for (Result result : results) {
			searchResponse = new NearestSearchResponse();
			searchResponse.setName(result.getName());
			searchResponse.setLocation(result.getFormattedAddress());
			String type = searchType.split(" ")[0];
			if (result.getTypes().get(0).contains(type.toLowerCase())) {
				searchResponse.setTypes(result.getTypes().get(0));
			} else {
				searchResponse.setTypes("NA");
			}
			searchResponse.setRating(result.getRating());
			if (result.getPhotos() != null) {
				searchResponse.setMoreInfoLink(getInfoLink(result.getPhotos()
						.get(0).getHtmlAttributions().get(0)));
			} else {
				searchResponse.setMoreInfoLink("");
			}
			searchList.add(searchResponse);
		}
		return searchList;

	}

	public static String getInfoLink(String text) {
		return text.substring(text.indexOf("https"), text.indexOf(">") - 1);
	}
}

package com.google.location.track.api.search.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.location.track.api.dto.Geometry;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {

	@SerializedName("formatted_address")
	@Expose
	@JsonProperty(value = "formatted_address")
	private String formattedAddress;
	@SerializedName("geometry")
	@Expose
	private Geometry geometry;
	@SerializedName("icon")
	@Expose
	private String icon;
	@SerializedName("id")
	@Expose
	private String id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("photos")
	@Expose
	private List<Photo> photos = null;
	@SerializedName("place_id")
	@Expose
	private String placeId;
	@SerializedName("rating")
	@Expose
	private double rating;
	@SerializedName("reference")
	@Expose
	private String reference;
	@SerializedName("types")
	@Expose
	private List<String> types = null;
	@SerializedName("opening_hours")
	@Expose
	private OpeningHours openingHours;
	private final static long serialVersionUID = 4031251883127582973L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Result() {
	}

	/**
	 * 
	 * @param photos
	 * @param id
	 * @param icon
	 * @param openingHours
	 * @param placeId
	 * @param name
	 * @param formattedAddress
	 * @param rating
	 * @param types
	 * @param reference
	 * @param geometry
	 */
	public Result(String formattedAddress, Geometry geometry, String icon,
			String id, String name, List<Photo> photos, String placeId,
			double rating, String reference, List<String> types,
			OpeningHours openingHours) {
		super();
		this.formattedAddress = formattedAddress;
		this.geometry = geometry;
		this.icon = icon;
		this.id = id;
		this.name = name;
		this.photos = photos;
		this.placeId = placeId;
		this.rating = rating;
		this.reference = reference;
		this.types = types;
		this.openingHours = openingHours;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public OpeningHours getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(OpeningHours openingHours) {
		this.openingHours = openingHours;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(formattedAddress).append(geometry)
				.append(icon).append(id).append(name).append(photos)
				.append(placeId).append(rating).append(reference).append(types)
				.append(openingHours).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Result) == false) {
			return false;
		}
		Result rhs = ((Result) other);
		return new EqualsBuilder()
				.append(formattedAddress, rhs.formattedAddress)
				.append(geometry, rhs.geometry).append(icon, rhs.icon)
				.append(id, rhs.id).append(name, rhs.name)
				.append(photos, rhs.photos).append(placeId, rhs.placeId)
				.append(rating, rhs.rating).append(reference, rhs.reference)
				.append(types, rhs.types)
				.append(openingHours, rhs.openingHours).isEquals();
	}

}

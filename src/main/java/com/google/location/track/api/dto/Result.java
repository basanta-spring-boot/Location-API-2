package com.google.location.track.api.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(value = { "address_components", "formatted_address",
		"geometry", "place_id", "types" })
public class Result implements Serializable {

	@SerializedName("address_components")
	@Expose
	@JsonProperty(value = "address_components")
	private List<AddressComponent> addressComponents;
	@SerializedName("formatted_address")
	@Expose
	@JsonProperty(value = "formatted_address")
	private String formattedAddress;
	@SerializedName("geometry")
	@Expose
	private Geometry geometry;
	@SerializedName("place_id")
	@Expose
	@JsonProperty(value = "place_id")
	private String placeId;
	@SerializedName("types")
	@Expose
	private List<String> types;
	private final static long serialVersionUID = -6506000888109815838L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Result() {
	}

	/**
	 * 
	 * @param placeId
	 * @param formattedAddress
	 * @param types
	 * @param addressComponents
	 * @param geometry
	 */
	public Result(List<AddressComponent> addressComponents,
			String formattedAddress, Geometry geometry, String placeId,
			List<String> types) {
		super();
		this.addressComponents = addressComponents;
		this.formattedAddress = formattedAddress;
		this.geometry = geometry;
		this.placeId = placeId;
		this.types = types;
	}

	public List<AddressComponent> getAddressComponents() {
		return addressComponents;
	}

	public void setAddressComponents(List<AddressComponent> addressComponents) {
		this.addressComponents = addressComponents;
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

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(addressComponents)
				.append(formattedAddress).append(geometry).append(placeId)
				.append(types).toHashCode();
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
				.append(addressComponents, rhs.addressComponents)
				.append(formattedAddress, rhs.formattedAddress)
				.append(geometry, rhs.geometry).append(placeId, rhs.placeId)
				.append(types, rhs.types).isEquals();
	}

}

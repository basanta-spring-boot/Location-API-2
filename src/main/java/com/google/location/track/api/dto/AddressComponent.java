package com.google.location.track.api.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressComponent implements Serializable {

	@SerializedName("long_name")
	@Expose
	@JsonProperty(value = "long_name")
	private String longName;
	@SerializedName("short_name")
	@Expose
	@JsonProperty(value = "short_name")
	private String shortName;
	@SerializedName("types")
	@Expose
	private List<String> types = null;
	private final static long serialVersionUID = -8460899875805060373L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public AddressComponent() {
	}

	/**
	 * 
	 * @param longName
	 * @param types
	 * @param shortName
	 */
	public AddressComponent(String longName, String shortName,
			List<String> types) {
		super();
		this.longName = longName;
		this.shortName = shortName;
		this.types = types;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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
		return new HashCodeBuilder().append(longName).append(shortName)
				.append(types).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof AddressComponent) == false) {
			return false;
		}
		AddressComponent rhs = ((AddressComponent) other);
		return new EqualsBuilder().append(longName, rhs.longName)
				.append(shortName, rhs.shortName).append(types, rhs.types)
				.isEquals();
	}

}

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

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo implements Serializable {

	@SerializedName("height")
	@Expose
	private long height;
	@SerializedName("html_attributions")
	@Expose
	@JsonProperty(value = "html_attributions")
	private List<String> htmlAttributions;
	@SerializedName("photo_reference")
	@Expose
	private String photoReference;
	@SerializedName("width")
	@Expose
	private long width;
	private final static long serialVersionUID = -7532702882941379792L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Photo() {
	}

	/**
	 * 
	 * @param height
	 * @param width
	 * @param htmlAttributions
	 * @param photoReference
	 */
	public Photo(long height, List<String> htmlAttributions,
			String photoReference, long width) {
		super();
		this.height = height;
		this.htmlAttributions = htmlAttributions;
		this.photoReference = photoReference;
		this.width = width;
	}

	public long getHeight() {
		return height;
	}

	public void setHeight(long height) {
		this.height = height;
	}

	public List<String> getHtmlAttributions() {
		return htmlAttributions;
	}

	public void setHtmlAttributions(List<String> htmlAttributions) {
		this.htmlAttributions = htmlAttributions;
	}

	public String getPhotoReference() {
		return photoReference;
	}

	public void setPhotoReference(String photoReference) {
		this.photoReference = photoReference;
	}

	public long getWidth() {
		return width;
	}

	public void setWidth(long width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(height).append(htmlAttributions)
				.append(photoReference).append(width).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Photo) == false) {
			return false;
		}
		Photo rhs = ((Photo) other);
		return new EqualsBuilder().append(height, rhs.height)
				.append(htmlAttributions, rhs.htmlAttributions)
				.append(photoReference, rhs.photoReference)
				.append(width, rhs.width).isEquals();
	}

}

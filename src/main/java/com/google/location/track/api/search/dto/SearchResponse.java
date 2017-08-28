package com.google.location.track.api.search.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponse implements Serializable {

	@SerializedName("html_attributions")
	@Expose
	@JsonProperty(value = "html_attributions")
	private List<Object> htmlAttributions;
	@SerializedName("results")
	@Expose
	private List<Result> results;
	@SerializedName("status")
	@Expose
	private String status;
	private final static long serialVersionUID = 4539713789019834843L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public SearchResponse() {
	}

	/**
	 * 
	 * @param results
	 * @param status
	 * @param htmlAttributions
	 */
	public SearchResponse(List<Object> htmlAttributions, List<Result> results,
			String status) {
		super();
		this.htmlAttributions = htmlAttributions;
		this.results = results;
		this.status = status;
	}

	public List<Object> getHtmlAttributions() {
		return htmlAttributions;
	}

	public void setHtmlAttributions(List<Object> htmlAttributions) {
		this.htmlAttributions = htmlAttributions;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(htmlAttributions).append(results)
				.append(status).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof SearchResponse) == false) {
			return false;
		}
		SearchResponse rhs = ((SearchResponse) other);
		return new EqualsBuilder()
				.append(htmlAttributions, rhs.htmlAttributions)
				.append(results, rhs.results).append(status, rhs.status)
				.isEquals();
	}

}

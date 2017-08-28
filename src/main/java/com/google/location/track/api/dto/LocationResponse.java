
package com.google.location.track.api.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationResponse implements Serializable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("status")
    @Expose
    private String status;
    private final static long serialVersionUID = -3252429863352719841L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LocationResponse() {
    }

    /**
     * 
     * @param results
     * @param status
     */
    public LocationResponse(List<Result> results, String status) {
        super();
        this.results = results;
        this.status = status;
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
        return new HashCodeBuilder().append(results).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LocationResponse) == false) {
            return false;
        }
        LocationResponse rhs = ((LocationResponse) other);
        return new EqualsBuilder().append(results, rhs.results).append(status, rhs.status).isEquals();
    }

}

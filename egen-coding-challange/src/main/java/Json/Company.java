
package Json;

import java.io.Serializable;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "street",
    "city",
    "zip",
    "state",
    "country"
})


public @Data class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2675066064598160276L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("website")
	private String website;
	
}
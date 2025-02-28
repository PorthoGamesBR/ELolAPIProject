package com.tiamat.portho.elolservice.PartidaEmAndamento;

//import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League {
	
	@JsonProperty("id")
	private Long id;
	@JsonProperty("slug")
	private String slug;
	@JsonProperty("name")
	private String name;
	/*
	private String image; 
	private Integer priority;
	private Map<String, Object> displayPriority;
	*/
	
	public League() {
		super();
	}
	
	public League(Long id, String slug, String name) {
		this.id = id;
		this.slug = slug;
		this.name = name;
	}
	
	public Long getId() {
		return this.id;
	}

	public String getSlug() {
		return this.slug;
	}
	
	public String getName() {
		return this.name;
	}

	/*
	public String getImage() {
		return image;
	}

	public Integer getPriority() {
		return priority;
	}

	public Map<String, Object> getDisplayPriority() {
		return displayPriority;
	}
	*/
}

package com.tiamat.portho.elolservice.PartidaEmAndamento;

//import java.util.List;
//import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LolLiveEvent {

	@JsonProperty("id")
	private Long id;
//	private String startTime;
	@JsonProperty("type")
	private String type;
	@JsonProperty("state")
	private String state;
	@JsonProperty("league")
	private League league;
//	private Map<String, Long> tournament;
//	private List<Object> streams;
//  private Object match;
	
	public LolLiveEvent() {
		super();
	}
	
	public LolLiveEvent(Long id, String state, League league) {
		this.id = id;
		this.state = state;
		this.league = league;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getState() {
		return state;
	}
	
	public League getLeague() {
		return league;
	}
	
	public String getType() {
		return type;
	}
	
	/*
	public Map<String, Long> getTournament() {
		return this.tournament;
	}
	
	public Long getTournamentId() {
		return tournament.get("id");
	}

	public String getStartTime() {
		return startTime;
	}

	public String getType() {
		return type;
	}


	public List<Object> getStreams() {
		return streams;
	}
	*/
	
}

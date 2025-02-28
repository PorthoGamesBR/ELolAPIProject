package com.tiamat.portho.elolservice.PartidaFinalizada;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LolEvent (LeagueMatch match, String state, String type){}

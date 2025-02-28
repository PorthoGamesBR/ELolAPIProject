package com.tiamat.portho.elolservice.PartidaEmAndamento;

public class FilterLolEventByLeagueId implements ILolEventFilter<Long> {
	
	@Override
	public Long get(LolLiveEvent lle) {
		return lle.getLeague().getId();
	}
}

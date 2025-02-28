package com.tiamat.portho.elolservice.PartidaEmAndamento;

public class FilterLolEventBySlug implements ILolEventFilter<String> {

	@Override
	public String get(LolLiveEvent lle) {
		// TODO Auto-generated method stub
		return lle.getLeague().getSlug();
	}
	

}

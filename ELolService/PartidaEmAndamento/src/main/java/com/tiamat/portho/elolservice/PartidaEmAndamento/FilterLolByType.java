package com.tiamat.portho.elolservice.PartidaEmAndamento;

public class FilterLolByType implements ILolEventFilter<String> {

	@Override
	public String get(LolLiveEvent lle) {
		return lle.getType();
	}
	

}

package com.tiamat.portho.elolservice.PartidaFinalizada;

public class FilterLolEvent implements ILolEventFilter<LolEvent> {

	@Override
	public LolEvent get(LolEvent lle) {
		return lle;
	}

}

package com.tiamat.portho.elolservice.PartidaEmAndamento;

public interface ILolEventFilter <T> {
	public T get(LolLiveEvent lle);
}

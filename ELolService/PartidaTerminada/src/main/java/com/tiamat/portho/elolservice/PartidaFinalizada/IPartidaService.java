package com.tiamat.portho.elolservice.PartidaFinalizada;


public interface IPartidaService {
	public <T> LolEvent getLolEventByFilter(T toFilter, ILolEventFilter<T> filter);
	public Boolean online();
}

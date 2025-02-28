package com.tiamat.portho.elolservice.PartidaEmAndamento;

import java.util.List;

public interface IPartidaService {
	public List<LolLiveEvent> getLolLiveEvents();
	public <T> List<LolLiveEvent> getLolEventsByFilter(List<T> toFilter, ILolEventFilter<T> filter);
	public Boolean online();
}

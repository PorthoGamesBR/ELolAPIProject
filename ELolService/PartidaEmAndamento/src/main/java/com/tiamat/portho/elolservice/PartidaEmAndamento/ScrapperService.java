package com.tiamat.portho.elolservice.PartidaEmAndamento;

import java.util.Arrays;
import java.util.List;

public class ScrapperService implements IPartidaService {
	
	private final String URLTOSCRAPE = "https://lolesports.com/pt-BR/";
	
	private LolLiveEvent mockEvent = new LolLiveEvent(
			Integer.toUnsignedLong(12345), 
			"live", 
			new League(
					Integer.toUnsignedLong(3456), 
					"LTA", 
					"League Tournament Americas"));
	
	@Override
	public List<LolLiveEvent> getLolLiveEvents() {
		return Arrays.asList(mockEvent);
	}

	@Override
	public <T> List<LolLiveEvent> getLolEventsByFilter(List<T> toFilter, ILolEventFilter<T> filter) {
		return Arrays.asList(mockEvent);
	}

	@Override
	public Boolean online() {
		return true;
	}

}

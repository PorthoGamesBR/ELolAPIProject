package com.tiamat.portho.elolservice.PartidaEmAndamento;

import java.util.Arrays;
import java.util.List;

public class TestService implements IPartidaService {
	
	private List<LolLiveEvent> mockLeagueEvents = Arrays.asList(
			new LolLiveEvent(
			Integer.toUnsignedLong(12345), 
			"live", 
			new League(
					Integer.toUnsignedLong(3456), 
					"lta", 
					"LTA")),
			new LolLiveEvent(
					Integer.toUnsignedLong(67890), 
					"live", 
					new League(
							Integer.toUnsignedLong(7890), 
							"lck", 
							"LCK")));
	
	@Override
	public List<LolLiveEvent> getLolLiveEvents() {
		return mockLeagueEvents;
	}

	@Override
	public <T> List<LolLiveEvent> getLolEventsByFilter(List<T> toFilter, ILolEventFilter<T> filter) {
		return mockLeagueEvents.stream()
				.filter(le -> toFilter.contains(filter.get(le)))
				.toList();
	}

	@Override
	public Boolean online() {
		return true;
	}

}

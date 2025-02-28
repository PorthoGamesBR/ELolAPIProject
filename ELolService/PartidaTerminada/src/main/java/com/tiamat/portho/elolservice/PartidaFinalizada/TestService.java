package com.tiamat.portho.elolservice.PartidaFinalizada;

import java.util.Arrays;
import java.util.List;

public class TestService implements IPartidaService {
	
	private List<LolEvent> mockLeagueEvents = Arrays.asList(
			new LolEvent( 
					new LeagueMatch(
					Integer.toUnsignedLong(12345)),
			"completed",
			"match"),
			new LolEvent( 
					new LeagueMatch(
					Integer.toUnsignedLong(67890)),
			"live",
			"match"),
			new LolEvent( 
					new LeagueMatch(
					Integer.toUnsignedLong(13579)),
			"live",
			"show"));


	@Override
	public Boolean online() {
		return true;
	}

	@Override
	public <T> LolEvent getLolEventByFilter(T toFilter, ILolEventFilter<T> filter) {
		
		return mockLeagueEvents.stream()
				.filter(le -> filter.get(le).equals(toFilter))
				.toList()
				.get(0);
	}

}

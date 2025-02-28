package com.tiamat.portho.elolservice.PartidaFinalizada;


public class ScrapperService implements IPartidaService {
	
	private final String URLTOSCRAPE = "https://lolesports.com/pt-BR/";
	
	private LolEvent mockEvent = new LolEvent(
			new LeagueMatch(
					Integer.toUnsignedLong(3456)),
			"completed",
			"match"
			);


	@Override
	public Boolean online() {
		return true;
	}


	@Override
	public <T> LolEvent getLolEventByFilter(T toFilter, ILolEventFilter<T> filter) {
		return mockEvent;
	}

}

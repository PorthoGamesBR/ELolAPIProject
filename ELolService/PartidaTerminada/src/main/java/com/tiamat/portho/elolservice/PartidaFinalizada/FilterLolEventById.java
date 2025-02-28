package com.tiamat.portho.elolservice.PartidaFinalizada;

public class FilterLolEventById implements ILolEventFilter<Long> {
	
	@Override
	public Long get(LolEvent lle) {
		try {
			return lle.match().id();
		}
		catch (java.lang.NullPointerException e) {
			System.out.println("ERROR IN FilterLolEventByID: Match not found in event");
			throw new java.lang.NullPointerException("FilterLolEventByID: Match not found in event");
		}
		
	}
}

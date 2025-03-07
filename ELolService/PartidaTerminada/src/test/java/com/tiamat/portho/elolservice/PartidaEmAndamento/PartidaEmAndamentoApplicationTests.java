package com.tiamat.portho.elolservice.PartidaEmAndamento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.tiamat.portho.elolservice.PartidaFinalizada.*;

// @SpringBootTest

@ContextConfiguration(classes = PartidaTerminadaApplication.class)
class PartidaEmAndamentoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testLeagueEventEquality() {
		LolEvent le = new LolEvent(new LeagueMatch(Integer.toUnsignedLong(12345)), "inProgress", "match");
		LolEvent le2 = new LolEvent(new LeagueMatch(Integer.toUnsignedLong(12345)), "inProgress", "match");
		Assertions.assertEquals(le, le2);
	}
	
	@Test
	void testLeagueEventNonEquality() {
		LolEvent le = new LolEvent(new LeagueMatch(Integer.toUnsignedLong(12345)), "inProgress", "match");
		
		LolEvent le2 = new LolEvent(new LeagueMatch(Integer.toUnsignedLong(12345)), "completed", "match");
		
		LolEvent le3 = new LolEvent(new LeagueMatch(Integer.toUnsignedLong(12345)), "inProgress", "show");
		
		LolEvent le4 = new LolEvent(new LeagueMatch(Integer.toUnsignedLong(54321)), "inProgress", "match");
		
		Assertions.assertNotEquals(le, le2);
		Assertions.assertNotEquals(le, le3);
		Assertions.assertNotEquals(le, le4);
	}

}

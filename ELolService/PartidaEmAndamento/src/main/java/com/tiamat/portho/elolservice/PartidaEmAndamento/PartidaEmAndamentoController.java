package com.tiamat.portho.elolservice.PartidaEmAndamento;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PartidaEmAndamentoController {
	
	@Autowired
	private IPartidaService partidaService;
	
	
	@GetMapping("/all")
	public List<LolLiveEvent> todasPartidasEmAndamento() {
		return filtrarEventosDePartida(
				partidaService.getLolLiveEvents()
				);
	}
	
	@GetMapping("/byLeagueSlug/{leagues}")
	public List<LolLiveEvent> partidasEmAndamentoPorSlug(@PathVariable String[] leagues) {
		return filtrarEventosDePartida(
				partidaService.getLolEventsByFilter(
						Arrays.asList(leagues) , new FilterLolEventBySlug())
				);
	}
	
	@GetMapping("/byLeagueId/{ids}")
	public List<LolLiveEvent> partidasEmAndamentoPorId(@PathVariable Long[] ids) {		
		return filtrarEventosDePartida(
				partidaService.getLolEventsByFilter(
						Arrays.asList(ids) , new FilterLolEventByLeagueId())
				);
	}
	
	private List<LolLiveEvent> filtrarEventosDePartida(List<LolLiveEvent> toFilter) {
		return toFilter.stream().filter(e -> e.getType() == "match").toList();
	}
	
}

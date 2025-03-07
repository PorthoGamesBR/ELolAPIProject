package com.tiamat.portho.elolservice.PartidaFinalizada;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PartidaTerminadaController {
	
//	@Autowired
//	private LiveLolService liveService;
	@Autowired
	private IPartidaService partidaService;

	@GetMapping("/byPartidaId/{partidaId}")
	public ResponseEntity<HasEnded> partidasFinalizadaPorId(@PathVariable Long partidaId) {
		try {
			LolEvent le = partidaService.getLolEventByFilter(partidaId , new FilterLolEventById());
		
			if (isLolEventLive(le)) 
				return new ResponseEntity<>(new HasEnded(false), HttpStatus.OK);
			return new ResponseEntity<>(new HasEnded(true), HttpStatus.OK); 
		
		}
		catch (EmptyMatchException e) {
			return new ResponseEntity<>(new HasEnded(true), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(new HasEnded(true), HttpStatus.NOT_FOUND);
		}
	}
	
	public Boolean isLolEventLive(LolEvent le) {
		return (le.type() == "show" || 
				le.state() == "inProgress" || 
				(le.state() != "unstarted" && le.state() != "completed"));
	}
	
}

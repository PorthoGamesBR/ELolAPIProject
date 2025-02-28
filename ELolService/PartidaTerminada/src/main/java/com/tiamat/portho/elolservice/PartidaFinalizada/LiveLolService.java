package com.tiamat.portho.elolservice.PartidaFinalizada;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LiveLolService implements IPartidaService {

	@Autowired
	private RestTemplate template = new RestTemplate();
	private ObjectMapper objectMapper = new ObjectMapper();
			
	private final String ADRESSBASEURL = "https://esports-api.lolesports.com/persisted/gw/getLive?hl=pt-BR";
	

	@SuppressWarnings("unchecked")
	public List<Object> getEvents() {
		Map<String, Object> response = template.getForObject(ADRESSBASEURL, Map.class);
        
        // Accessing the nested structure
        Map<String, Object> data = (Map<String, Object>) response.get("data");
        Map<String, Object> schedule = (Map<String, Object>) data.get("schedule");
        List<Object> objectEventList = (List<Object>) schedule.get("events");
        
		return objectEventList;
	}
	
	private List<LolEvent> getLolLiveEvents() {
		
		// getEvents().stream().forEach(System.out::println);
		
        List<LolEvent> eventsList = getEvents().stream()
        	.map(o -> objectMapper.convertValue(o, LolEvent.class))
        	.toList();
        eventsList.forEach(e -> System.out.println(e));
        
		return eventsList;
	}
	
	@Override
	public <T> LolEvent getLolEventByFilter(T toFilter, ILolEventFilter<T> filter) {
		List<LolEvent> eventsList = getLolLiveEvents();
		
		eventsList.forEach(e -> System.out.println(e));
		
		Optional<LolEvent> toReturn = eventsList.stream()
				.filter(le ->  filter.get(le).equals(toFilter))
				.findFirst();
		
		return toReturn.orElse(null);
	}

	@Override
	public Boolean online() {
		// TODO check request to see if it is online
		return true;
	}


}

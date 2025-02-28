package com.tiamat.portho.elolservice.PartidaEmAndamento;

import java.util.List;
import java.util.Map;

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
	
	@Override
	public List<LolLiveEvent> getLolLiveEvents() {
		
		// getEvents().stream().forEach(System.out::println);
		
        List<LolLiveEvent> eventsList = getEvents().stream()
        	.map(o -> objectMapper.convertValue(o, LolLiveEvent.class))
        	.toList();
        eventsList.forEach(e -> System.out.println(e));
        
		return eventsList;
	}
	
	@Override
	public <T> List<LolLiveEvent> getLolEventsByFilter(List<T> toFilter, ILolEventFilter<T> filter) {
		List<LolLiveEvent> eventsList = getLolLiveEvents();
		
		eventsList.forEach(e -> System.out.println(e));
		
		return  eventsList.stream()
				.filter(le ->  toFilter.contains(filter.get(le)))
				.toList();
	}

	@Override
	public Boolean online() {
		// TODO check request to see if it is online
		return true;
	}


}

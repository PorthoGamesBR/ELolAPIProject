package com.tiamat.portho.elolservice.PartidaFinalizada;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ScheduleLolService implements IPartidaService {

	@Autowired
	private RestTemplate template = new RestTemplate();
	private ObjectMapper objectMapper = new ObjectMapper();
			
	private final String ADRESSBASEURL = "https://esports-api.lolesports.com/persisted/gw/getSchedule?hl=pt-BR";
	

	@SuppressWarnings("unchecked")
	public List<Object> getEvents() {
		Map<String, Object> response = template.getForObject(ADRESSBASEURL, Map.class);
        
        // Accessing the nested structure
        Map<String, Object> data = (Map<String, Object>) response.get("data");
        Map<String, Object> schedule = (Map<String, Object>) data.get("schedule");
        List<Object> objectEventList = (List<Object>) schedule.get("events");
        
		return objectEventList;
	}
	
	public List<LolEvent> getLolEvents() {
        List<LolEvent> eventsList = getEvents().stream()
        	.map(o -> objectMapper.convertValue(o, LolEvent.class))
        	.toList();
        
		return eventsList;
	}

	@Override
	public Boolean online() {
		// TODO check request to see if it is online
		return true;
	}

	@Override
	public <T> LolEvent getLolEventByFilter(T toFilter, ILolEventFilter<T> filter) {
		LolEvent toReturn;
		
		try {
			toReturn = getLolEvents().stream()
					.filter(le ->  filter.get(le).equals(toFilter))
					.toList()
					.get(0);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR IN LiveLolService: Not found a LolEvent with value " + toFilter);
			throw new ArrayIndexOutOfBoundsException("Not found a LolEvent with value " + toFilter);
		}
		return toReturn;
		
	}


}

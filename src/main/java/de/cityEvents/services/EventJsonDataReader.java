package de.cityEvents.services;

import de.cityEvents.entities.Event;
import de.cityEvents.repository.EventRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

@Service
public class EventJsonDataReader {

  @Autowired
  private EventRepository eventRepository;

  public void readEventJsonDataFile() {
    JSONParser parser = new JSONParser();

    try {

      Object obj = parser.parse(new FileReader(
          "src/main/webapp/EventData.json"));

      JSONArray eventDataArray = (JSONArray) obj;

      Iterator<JSONObject> eventIterator = eventDataArray.iterator();
      while (eventIterator.hasNext()) {
        JSONObject jsonEvent = eventIterator.next();
        Event event = new Event();
        event.setEventName((String)jsonEvent.get("Name"));
        event.setPictureName((String)jsonEvent.get("Bild"));
        event.setPitch((String)jsonEvent.get("Pitch"));
        ArrayList<String> listItems = new ArrayList<String>();
        Iterator<String> checkListIterator = ((JSONArray)jsonEvent.get("Inhalt")).iterator();
        while (checkListIterator.hasNext()) {
          listItems.add(checkListIterator.next());
        }

        event.setCheckListItems(listItems);
        event.setDescription((String)jsonEvent.get("Beschreibung"));
        event.setPrice((String)jsonEvent.get("Preis"));
        event.setPostalCode((String)jsonEvent.get("PLZ"));

        eventRepository.save(event);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}

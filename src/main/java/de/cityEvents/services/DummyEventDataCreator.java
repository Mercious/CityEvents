package de.cityEvents.services;

import de.cityEvents.entities.Event;
import de.cityEvents.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

@Service
public class DummyEventDataCreator {

    @Autowired
    private EventRepository eventRepository;

    public void createDummyEventJsonData() {
        int count = 3;
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/webapp/plz_liste.txt"))) {
            for(String line; (line = br.readLine()) != null; ) {
                // create a dummy event for every PLZ
                Event dummyEvent = new Event();
                dummyEvent.setEventName("Dummy Event " + ++count);
                dummyEvent.setPitch("Nur ein Beispiel");
                if (count % 2 == 0) {
                    dummyEvent.setCheckListItems(Collections.singletonList("Dummy Inhalt."));
                    dummyEvent.setPrice("");
                } else {
                    dummyEvent.setDescription("Beispiel Beschreibung.");
                    dummyEvent.setPrice("€ " + (100 + 8 * (count % 24)));
                }

                dummyEvent.setPostalCode(line);
                dummyEvent.setPictureName("Event_0" + (count % 10) + ".jpg");

                eventRepository.save(dummyEvent);
            }
            // line is not visible here.
        } catch (IOException e) {
            // error handling
        }
    }
}

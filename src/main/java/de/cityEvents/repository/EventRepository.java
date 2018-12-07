package de.cityEvents.repository;

import de.cityEvents.entities.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {

  List<Event> findByEventName(String eventName);
  List<Event> findByEventNameContaining(final String eventName);
}

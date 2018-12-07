package de.cityEvents;

import de.cityEvents.services.DummyEventDataCreator;
import de.cityEvents.services.EventJsonDataReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CityEventsApplication  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CityEventsApplication.class);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CityEventsApplication.class, args);

        // the 3 examples for the homepage teaser
        context.getBean(EventJsonDataReader.class).readEventJsonDataFile();
        // all dummy's for search results
        context.getBean(DummyEventDataCreator.class).createDummyEventJsonData();


    }
}

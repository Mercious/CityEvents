package de.cityEvents.controller;

import de.cityEvents.entities.Event;
import de.cityEvents.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
public class HomePageController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/home")
    public ModelAndView sayHelloWorld() {
        ModelMap modelMap = new ModelMap();
        int count = 0;
        ArrayList<Event> resultList = new ArrayList<>();
        for (Event event : eventRepository.findAll()) {
            if (count >= 10)
                break;
            resultList.add(event);
            count++;
        }
        modelMap.put("events", resultList);
        return new ModelAndView("HomePage", modelMap);
    }
}

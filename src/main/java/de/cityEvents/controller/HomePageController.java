package de.cityEvents.controller;

import de.cityEvents.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/home")
    public ModelAndView sayHelloWorld() {
        ModelMap modelMap = new ModelMap();
        modelMap.put("events", eventRepository.findAll());
        return new ModelAndView("HomePage", modelMap);
    }
}

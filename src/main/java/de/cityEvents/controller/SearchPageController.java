package de.cityEvents.controller;

import de.cityEvents.entities.Event;
import de.cityEvents.repository.EventRepository;
import de.cityEvents.services.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchPageController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GeoService geoService;

    @RequestMapping(value = "/searchPostalCode", method = RequestMethod.GET)
    public ModelAndView searchForEventOrPlz(final HttpServletRequest request) {
        final String searchPostalCode = request.getParameter("searchPostalCode");
        final String areaSetting = request.getParameter("areaSetting");

        final ModelMap modelMap = new ModelMap();
        List<String> postalCodesNear = geoService.findPostalCodesNear(searchPostalCode, areaSetting);

        final ArrayList<Event> resultList = new ArrayList<>();
        for (final Event resultEvent : eventRepository.findAll()) {
            if (postalCodesNear.contains(resultEvent.getPostalCode())) {
                resultList.add(resultEvent);
            }
        }

        modelMap.put("events", resultList);
        modelMap.put("searchRequest", "Events in der Nähe von PLZ " + searchPostalCode);
        return new ModelAndView("SearchPage", modelMap);
    }

    @RequestMapping(value = "/searchTerm", method = RequestMethod.GET)
    public ModelAndView searchForEventName(final HttpServletRequest request) {
        final String searchString = request.getParameter("searchTerm");
        final ModelMap modelMap = new ModelMap();
        modelMap.put("events", eventRepository.findByEventNameContaining(searchString));
        modelMap.put("searchRequest", searchString);
        return new ModelAndView("SearchPage", modelMap);
    }



}

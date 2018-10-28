package de.cityEvents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

    @RequestMapping("/helloWorld")
    public ModelAndView sayHelloWorld() {
        return new ModelAndView("HomePage");
    }
}

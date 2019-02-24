package eu.pyprincess.weatherapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    /**
     * Serves the static files
     *
     */
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}

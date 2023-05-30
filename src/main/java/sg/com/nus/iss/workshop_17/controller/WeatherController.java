package sg.com.nus.iss.workshop_17.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.com.nus.iss.workshop_17.model.Weather;
import sg.com.nus.iss.workshop_17.service.WeatherService;

@Controller
@RequestMapping(path="/weather")
public class WeatherController {

    @Autowired
    private WeatherService wSvc;

    // @GetMapping(path="/")
    // public String homePage(Model m) {

    // }

    /*
     *  First parameter will be the requested city name.
     *  Second parameter will be the unit of measurement if any, if not default to metric.
     *  Model object to bind the retrieved info and render in following webpage.
     */
    @GetMapping
    public String getWeather(@RequestParam(required=true) String city, @RequestParam(defaultValue = "metric",required=false) String units, 
                Model model) throws IOException {

        Optional<Weather> w = wSvc.getWeather(city, units);
        model.addAttribute("weather", w.get());
        return "weather";
    }
    
}

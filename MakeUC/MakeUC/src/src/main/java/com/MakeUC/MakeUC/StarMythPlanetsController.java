package com.MakeUC.MakeUC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StarMythPlanetsController {
    @RequestMapping("/Planets")
    public String home() {
        return "StarMythPlanets";
    }

    @GetMapping("/Planets/search")
    public String search_stuff(@RequestParam(value = "type") String type) {
        return "StarSearch";
    }
}
package com.MakeUC.MakeUC;

public class ConstellationController
{
    @RequestMapping("/ConstellationControl")
    public String hello() {
        return "SpacexHome";
    }

    @GetMapping("/")
    public String search(@RequestParam(value="type") String type) {
        return "Search";
    }
}
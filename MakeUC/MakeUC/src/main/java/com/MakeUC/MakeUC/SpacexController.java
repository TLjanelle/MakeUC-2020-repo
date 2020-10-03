package com.MakeUC.MakeUC;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpacexController {

    @RequestMapping("/Spacex")
    public String index() {
        return "SpacexHome";
    }

    @RequestMapping("/Spacex/search")
    public String search(@RequestParam(value = "type") String type) {
        switch (type) {
            case "capsules":
                return "redirect:capsules";
            case "cores":
                return "redirect:cores";
            case "ships":
                return "redirect:Ships";
        }

        return "Search";
    }

    @RequestMapping("/Spacex/Capsules")
    public String Capsules(Model model) {
        JSONObject apiJSON = JSONReader.readJSON(("https://api.spacexdata.com/v3/capsules"), "{response:", "}");

        JSONArray dataArr = apiJSON.getJSONArray("response");

        Capsule[] response = new Capsule[dataArr.length()];
        for (int i=0; i < dataArr.length(); i++) {
            JSONObject json = dataArr.getJSONObject(i);
            response[i] = new Capsule(
                    json.getString("capsule_id"),
                    json.getString("capsule_serial"),
                    json.getString("status"),
                    json.getInt("landings"),
                    json.getString("type"),
                    json.getInt("reuse_count")
            );
            try {
                response[i].setDetails(json.getString("details"));
            } catch (Exception e) {

            }
            try {
                response[i].setLaunch(json.getString("original_launch"));
            } catch (Exception e) {

            }

            JSONArray missDat = json.getJSONArray("missions");
            String[] missions = new String[missDat.length()];
            for (int j=0; j < missDat.length(); j++) {
                missions[j] = missDat.getJSONObject(j).getString("name");
            }
            response[i].setMissionNames(missions);
        }
        model.addAttribute("capsules", response);
        return "Capsules";
    }

    @RequestMapping("/Spacex/Cores")
    public String Cores(Model model) {
        JSONObject apiJSON = JSONReader.readJSON(("https://api.spacexdata.com/v3/cores"), "{response:", "}");

        JSONArray dataArr = apiJSON.getJSONArray("response");

        Core[] response = new Core[dataArr.length()];
        for (int i=0; i < dataArr.length(); i++) {
            JSONObject json = dataArr.getJSONObject(i);
            response[i] = new Core(
                    json.getString("core_serial"),
                    json.getInt("reuse_count"),
                    json.getInt("rtls_attempts"),
                    json.getInt("rtls_landings"),
                    json.getInt("asds_attempts"),
                    json.getInt("asds_landings"),
                    json.getBoolean("water_landing")
            );
            try { response[i].setStatus(json.getString("status")); } catch (Exception e) { }
            try { response[i].setDetails(json.getString("details")); } catch (Exception e) { }
            try { response[i].setBlock(json.getInt("block")); } catch (Exception e) { }
            try { response[i].setLaunch(json.getString("original_launch")); } catch (Exception e) { }

            JSONArray missDat = json.getJSONArray("missions");
            String[] missions = new String[missDat.length()];
            for (int j=0; j < missDat.length(); j++) {
                missions[j] = missDat.getJSONObject(j).getString("name");
            }
            response[i].setMissions(missions);
        }
        model.addAttribute("cores", response);
        return "Cores";
    }


    @RequestMapping("/Spacex/Ships")
    public String Ships(Model model) {
        JSONObject apiJSON = JSONReader.readJSON(("https://api.spacexdata.com/v3/ships"), "{response:", "}");
   JSONArray data[][] = apiJSON.getJSONArray("response");

        Ship[] response = new Ship[dataArr.length()];
        for (int i=0; i < dataArr.length(); i++) {
            JSONObject json = dataArr.getJSONObject(i);
            response[i] = new Ships(
                json.getString("ship_id"),
                json.getString("ship_name"),
                json.getString("ship_model"),
                json.getString("ship_type"),
                json.getString("role"),
                json.getInt("year_built"),
                json.getString("home_port"),
                json.getString("status"),
                json.getInt("speed_kn"),
                json.getInt("course_deg"),
                json.getJSONArray("lattitude", "longitude"),
                json.getInt("successful_landings"),
                json.getInt("attempted_landing"),
                json.getString("mission")
                );
        }
    }
}
        /*   
            try { response[i].setStatus(json.getString("status")); } catch (Exception e) { }
            try { response[i].setDetails(json.getString("details")); } catch (Exception e) { }
            try { response[i].setBlock(json.getInt("block")); } catch (Exception e) { }
            try { response[i].setLaunch(json.getString("original_launch")); } catch (Exception e) { }

            JSONArray missDat = json.getJSONArray("missions");
            String[] missions = new String[missDat.length()];
            for (int j=0; j < missDat.length(); j++) {
                missions[j] = missDat.getJSONObject(j).getString("name");
            }
            response[i].setMissions(missions);
        }
        model.addAttribute("ships", response);
        return "Ships";
*/

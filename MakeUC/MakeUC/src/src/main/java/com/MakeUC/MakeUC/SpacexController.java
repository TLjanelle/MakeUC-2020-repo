package com.MakeUC.MakeUC;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpacexController {

    @RequestMapping("/")
    public String redirect() {
        return "redirect:Spacex";
    }

    @RequestMapping("/Spacex")
    public String index() {
        return "SpacexHome";
    }

    @RequestMapping("/Spacex/search")
    public String search(@RequestParam(value = "type") String type) {
        switch (type) {
            case "capsules":
                return "redirect:Capsules";
            case "cores":
                return "redirect:Cores";
            case "launches":
                return "redirect:Launches";
            case "missions":
                return "redirect:Missions";
            case "dragons":
                return "redirect:Dragons";
            case "rockets":
                return "redirect:Rockets";
            case "ships":
                return "redirect:Ships";
        }

        return "Search";
    }

    @RequestMapping("/Spacex/Capsules")
    public String Capsules(Model model) throws Exception {
        JSONObject apiJSON = JSONReader.readJSON(("https://api.spacexdata.com/v3/capsules"), "{response:", "}");

        JSONArray dataArr = apiJSON.getJSONArray("response");

        Capsule[] response = new Capsule[dataArr.length()];
        for (int i = 0; i < dataArr.length(); i++) {
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
            for (int j = 0; j < missDat.length(); j++) {
                missions[j] = missDat.getJSONObject(j).getString("name");
            }
            response[i].setMissionNames(missions);
        }
        model.addAttribute("capsules", response);
        return "Capsules";
    }

    @RequestMapping("/Spacex/Cores")
    public String Cores(Model model) throws Exception {
        JSONObject apiJSON = JSONReader.readJSON(("https://api.spacexdata.com/v3/cores"), "{response:", "}");

        JSONArray dataArr = apiJSON.getJSONArray("response");

        Core[] response = new Core[dataArr.length()];
        for (int i = 0; i < dataArr.length(); i++) {
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
            try {
                response[i].setStatus(json.getString("status"));
            } catch (Exception e) {
            }
            try {
                response[i].setDetails(json.getString("details"));
            } catch (Exception e) {
            }
            try {
                response[i].setBlock(json.getInt("block"));
            } catch (Exception e) {
            }
            try {
                response[i].setLaunch(json.getString("original_launch"));
            } catch (Exception e) {
            }

            JSONArray missDat = json.getJSONArray("missions");
            String[] missions = new String[missDat.length()];
            for (int j = 0; j < missDat.length(); j++) {
                missions[j] = missDat.getJSONObject(j).getString("name");
            }
            response[i].setMissions(missions);
        }
        model.addAttribute("cores", response);
        return "Cores";
    }

    @RequestMapping("/Spacex/Ships")
    public String Ships(Model model) throws Exception {
        JSONObject apiJSON = JSONReader.readJSON(("https://api.spacexdata.com/v3/ships"), "{response:", "}");
        JSONArray data = apiJSON.getJSONArray("response");

        Ship[] response = new Ship[data.length()];
        for (int i = 0; i < data.length(); i++) {
            JSONObject json = data.getJSONObject(i);
            response[i] = new Ship();
            response[i].name = json.getString("ship_name");
            response[i].type = json.getString("ship_type");

            JSONArray rolesJSON = json.getJSONArray("roles");
            String[] roles = new String[rolesJSON.length()];
            for (int j = 0; j < rolesJSON.length(); j++) {
                roles[j] = rolesJSON.getString(j);
            }
            response[i].roles = roles;
            response[i].active = json.getBoolean("active");
            try {
                response[i].weightkg = json.getInt("weight_kg");
            } catch (Exception e) {
                response[i].weightkg = 0;
            }
            try {
                response[i].weightlb = json.getInt("weight_lbs");
            } catch (Exception e) {
                response[i].weightlb = 0;
            }
            response[i].port = json.getString("home_port");

            JSONArray missionJSON = json.getJSONArray("missions");
            String[] missions = new String[missionJSON.length()];
            for (int j = 0; j < missionJSON.length(); j++) {
                missions[j] = missionJSON.getJSONObject(j).getString("name");
            }
            response[i].missions = missions;
            try {
                response[i].url = json.getString("url");
            } catch (Exception e) {
                response[i].url = null;
            }
            try {
                response[i].image = json.getString("image");
            } catch (Exception e) {
                response[i].image = null;
            }
        }
        model.addAttribute("ships", response);
        return "Ships";
    }

    @RequestMapping("/Spacex/Rockets")
    public String Rockets(Model model) throws Exception {
        JSONObject apiJSON = JSONReader.readJSON(("https://api.spacexdata.com/v3/rockets"), "{response:", "}");

        JSONArray dataArr = apiJSON.getJSONArray("response");

        Rocket[] response = new Rocket[dataArr.length()];
        for (int i = 0; i < dataArr.length(); i++) {
            response[i] = new Rocket();
            JSONObject json = dataArr.getJSONObject(i);
            try {
                response[i].active = json.getBoolean("active");
            } catch (Exception e) {
                response[i].active = null;
            }
            response[i].stages = json.getInt("stages");
            response[i].boosters = json.getInt("boosters");
            response[i].cost = json.getInt("cost_per_launch");
            response[i].successRate = json.getInt("success_rate_pct");
            response[i].o_launch = json.getString("first_flight");
            response[i].country = json.getString("country");
            response[i].company = json.getString("company");

            response[i].height = new Rocket.Height();
            response[i].height.meters = json.getJSONObject("height").getInt("meters");
            response[i].height.feet = json.getJSONObject("height").getInt("feet");

            response[i].diameter = new Rocket.Diameter();
            response[i].diameter.meters = json.getJSONObject("diameter").getDouble("meters");
            response[i].diameter.feet = json.getJSONObject("diameter").getDouble("feet");

            response[i].mass = new Rocket.Mass();
            response[i].mass.kilo = json.getJSONObject("mass").getInt("kg");
            response[i].mass.pounds = json.getJSONObject("mass").getInt("lb");

            JSONArray pl = json.getJSONArray("payload_weights");
            Rocket.Payload[] payloads = new Rocket.Payload[pl.length()];
            for (int j = 0; j < pl.length(); j++) {
                JSONObject data = pl.getJSONObject(j);
                payloads[j] = new Rocket.Payload();
                payloads[j].id = data.getString("id");
                payloads[j].name = data.getString("name");
                payloads[j].mass = new Rocket.Mass();
                payloads[j].mass.kilo = data.getInt("kg");
                payloads[j].mass.pounds = data.getInt("lb");
            }
            response[i].payloads = payloads;

            response[i].fs = new Rocket.FirstStage();
            JSONObject fs = json.getJSONObject("first_stage");
            response[i].fs.reusable = fs.getBoolean("reusable");
            response[i].fs.engines = fs.getInt("engines");
            response[i].fs.fuelTons = fs.getDouble("fuel_amount_tons");
            try {
                response[i].fs.burnSecs = fs.getInt("burn_time_sec");
            } catch (Exception e) {
                response[i].fs.burnSecs = null;
            }
            response[i].fs.thrustSea = new Rocket.Thrust();
            response[i].fs.thrustSea.kn = fs.getJSONObject("thrust_sea_level").getInt("kN");
            response[i].fs.thrustSea.lbf = fs.getJSONObject("thrust_sea_level").getInt("lbf");
            response[i].fs.thrustVac = new Rocket.Thrust();
            response[i].fs.thrustVac.kn = fs.getJSONObject("thrust_vacuum").getInt("kN");
            response[i].fs.thrustVac.lbf = fs.getJSONObject("thrust_vacuum").getInt("lbf");

            fs = json.getJSONObject("second_stage");
            response[i].ss = new Rocket.SecondStage();
            response[i].ss.reusable = fs.getBoolean("reusable");
            response[i].ss.engines = fs.getInt("engines");
            response[i].ss.fuelTons = fs.getDouble("fuel_amount_tons");
            try {
                response[i].ss.burnSecs = fs.getInt("burn_time_sec");
            } catch (Exception e) {
                response[i].ss.burnSecs = null;
            }
            response[i].ss.thrust = new Rocket.Thrust();
            response[i].ss.thrust.kn = fs.getJSONObject("thrust").getInt("kN");
            response[i].ss.thrust.lbf = fs.getJSONObject("thrust").getInt("lbf");

            fs = json.getJSONObject("engines");
            response[i].engines = new Rocket.Engines();
            response[i].engines.num = fs.getInt("number");
            response[i].engines.type = fs.getString("type");
            response[i].engines.version = fs.getString("version");
            try {
                response[i].engines.layout = fs.getString("layout");
            } catch (Exception e) {
                response[i].engines.layout = "";
            }
            response[i].engines.isp = new Rocket.Isp();
            response[i].engines.isp.seaLevel = fs.getJSONObject("isp").getInt("sea_level");
            response[i].engines.isp.vacuum = fs.getJSONObject("isp").getInt("vacuum");
            try {
                response[i].engines.engineMaxLoss = fs.getInt("engine_loss_max");
            } catch (Exception e) {
                response[i].engines.engineMaxLoss = null;
            }
            response[i].engines.prop1 = fs.getString("propellant_1");
            response[i].engines.prop2 = fs.getString("propellant_2");
            response[i].engines.seaLevel = new Rocket.Thrust();
            response[i].engines.seaLevel.kn = fs.getJSONObject("thrust_sea_level").getInt("kN");
            response[i].engines.seaLevel.lbf = fs.getJSONObject("thrust_vacuum").getInt("lbf");
            response[i].engines.thrustToWeight = fs.getInt("thrust_to_weight");

            fs = json.getJSONObject("landing_legs");
            response[i].landLegs = new Rocket.LandLegs();
            response[i].landLegs.num = fs.getInt("number");
            try {
                response[i].landLegs.material = fs.getString("material");
            } catch (Exception e) {
                response[i].landLegs.material = "";
            }

            JSONArray images = json.getJSONArray("flickr_images");
            String[] im = new String[images.length()];
            for (int j = 0; j < images.length(); j++) {
                im[j] = images.getString(j);
            }
            response[i].images = im;
            response[i].wiki = json.getString("wikipedia");
            response[i].description = json.getString("description");
            response[i].id = json.getString("rocket_id");
            response[i].name = json.getString("rocket_name");
            response[i].type = json.getString("rocket_type");
        }
        model.addAttribute("rockets", response);
        return "Rockets";
    }

    @RequestMapping("/Spacex/Missions")
    public String Missions(Model model) throws Exception {
        JSONObject apiJSON = JSONReader.readJSON(("https://api.spacexdata.com/v3/missions"), "{response:", "}");

        JSONArray dataArr = apiJSON.getJSONArray("response");

        Mission[] response = new Mission[dataArr.length()];
        for (int i = 0; i < dataArr.length(); i++) {
            JSONObject json = dataArr.getJSONObject(i);

            response[i] = new Mission();
            response[i].name = json.getString("mission_name");
            response[i].id = json.getString("mission_id");

            JSONArray jsonManus = json.getJSONArray("manufacturers");
            String[] manus = new String[jsonManus.length()];
            for (int j = 0; j < jsonManus.length(); j++) {
                manus[j] = jsonManus.getString(j);
            }
            response[i].manufacturers = manus;

            JSONArray jsonPayIds = json.getJSONArray("payload_ids");
            String[] payIds = new String[jsonPayIds.length()];
            for (int j = 0; j < jsonPayIds.length(); j++) {
                payIds[j] = jsonPayIds.getString(j);
            }
            response[i].payloadIds = payIds;

            response[i].wiki = json.getString("wikipedia");
            response[i].website = json.getString("website");
            try {
                response[i].twitter = json.getString("twitter");
            } catch (Exception e) {
                response[i].twitter = "";
            }
            response[i].description = json.getString("description");
        }
        model.addAttribute("missions", response);
        return "Missions";
    }

    @RequestMapping("/Spacex/Dragons")
    public String Dragons(Model model) throws Exception {
        JSONObject apiJSON = JSONReader.readJSON(("https://api.spacexdata.com/v3/dragons"), "{response:", "}");

        JSONArray dataArr = apiJSON.getJSONArray("response");

        Dragons[] response = new Dragons[dataArr.length()];
        for (int i = 0; i < dataArr.length(); i++) {
            JSONObject json = dataArr.getJSONObject(i);

            response[i] = new Dragons();
            response[i].name = json.getString("name");
            response[i].type = json.getString("type");
            response[i].active = json.getBoolean("active");
            response[i].capacity = json.getInt("crew_capacity");
            response[i].orbit = json.getInt("orbit_duration_yr");
            response[i].dryMassKg = json.getInt("dry_mass_kg");
            response[i].dryMassLb = json.getInt("dry_mass_lb");
            response[i].o_launch = json.getString("first_flight");

            response[i].shield = new Dragons.HeatShield();
            response[i].shield.material = json.getJSONObject("heat_shield").getString("material");
            response[i].shield.size = json.getJSONObject("heat_shield").getDouble("size_meters");
            response[i].shield.temp = json.getJSONObject("heat_shield").getInt("temp_degrees");
            response[i].shield.dev = json.getJSONObject("heat_shield").getString("dev_partner");

            JSONArray thrusArr = json.getJSONArray("thrusters");
            Dragons.Thruster[] thrustArr = new Dragons.Thruster[thrusArr.length()];
            for (int j = 0; j < thrusArr.length(); j++) {
                thrustArr[j] = new Dragons.Thruster();
                thrustArr[j].type = thrusArr.getJSONObject(j).getString("type");
                thrustArr[j].amount = thrusArr.getJSONObject(j).getInt("amount");
                thrustArr[j].pods = thrusArr.getJSONObject(j).getInt("pods");
                thrustArr[j].f1 = thrusArr.getJSONObject(j).getString("fuel_1");
                thrustArr[j].f2 = thrusArr.getJSONObject(j).getString("fuel_2");
                thrustArr[j].isp = thrusArr.getJSONObject(j).getInt("isp");
                thrustArr[j].thrustKn = thrusArr.getJSONObject(j).getJSONObject("thrust").getDouble("kN");
                thrustArr[j].thrustLbf = thrusArr.getJSONObject(j).getJSONObject("thrust").getInt("lbf");
            }
            response[i].thrusters = thrustArr;

            response[i].launch = new Dragons.Mass();
            response[i].launch.kg = json.getJSONObject("launch_payload_mass").getInt("kg");
            response[i].launch.lb = json.getJSONObject("launch_payload_mass").getInt("lb");

            response[i].launchVol = new Dragons.Vol();
            response[i].launchVol.meters = json.getJSONObject("launch_payload_vol").getInt("cubic_meters");
            response[i].launchVol.feet = json.getJSONObject("launch_payload_vol").getInt("cubic_feet");

            response[i].ret = new Dragons.Mass();
            response[i].ret.kg = json.getJSONObject("return_payload_mass").getInt("kg");
            response[i].ret.lb = json.getJSONObject("return_payload_mass").getInt("lb");

            response[i].retVol = new Dragons.Vol();
            response[i].retVol.meters = json.getJSONObject("return_payload_vol").getInt("cubic_meters");
            response[i].retVol.feet = json.getJSONObject("return_payload_vol").getInt("cubic_feet");

            response[i].pressVol = new Dragons.Vol();
            response[i].pressVol.meters = json.getJSONObject("pressurized_capsule").getJSONObject("payload_volume").getInt("cubic_meters");
            response[i].pressVol.feet = json.getJSONObject("pressurized_capsule").getJSONObject("payload_volume").getInt("cubic_feet");

            response[i].trunk = new Dragons.Trunk();
            response[i].trunk.vol = new Dragons.Vol();
            response[i].trunk.vol.meters = json.getJSONObject("trunk").getJSONObject("trunk_volume").getInt("cubic_meters");
            response[i].trunk.vol.feet = json.getJSONObject("trunk").getJSONObject("trunk_volume").getInt("cubic_feet");
            response[i].trunk.solArray = json.getJSONObject("trunk").getJSONObject("cargo").getInt("solar_array");
            response[i].trunk.cargo = json.getJSONObject("trunk").getJSONObject("cargo").getBoolean("unpressurized_cargo");

            response[i].heightWTruck = new Dragons.Vol();
            response[i].heightWTruck.meters = json.getJSONObject("height_w_trunk").getDouble("meters");
            response[i].heightWTruck.feet = json.getJSONObject("height_w_trunk").getDouble("feet");

            response[i].diameter = new Dragons.Vol();
            response[i].diameter.meters = json.getJSONObject("diameter").getDouble("meters");
            response[i].diameter.feet = json.getJSONObject("diameter").getDouble("feet");

            JSONArray jsonImgArr = json.getJSONArray("flickr_images");
            String[] imgs = new String[jsonImgArr.length()];
            for (int j = 0; j < jsonImgArr.length(); j++) {
                imgs[j] = jsonImgArr.getString(j);
            }
            response[i].images = imgs;
            response[i].wiki = json.getString("wikipedia");
            response[i].description = json.getString("description");


        }
        model.addAttribute("dragons", response);
        return "Dragons";
    }

    @RequestMapping("/Spacex/Launches")
    public String Launches(Model model) throws Exception {
        JSONObject apiJSON = JSONReader.readJSON(("https://api.spacexdata.com/v3/launches"), "{response:", "}");

        JSONArray dataArr = apiJSON.getJSONArray("response");

        Launch[] response = new Launch[dataArr.length()];
        for (int i = 0; i < dataArr.length(); i++) {
            JSONObject json = dataArr.getJSONObject(i);

            response[i] = new Launch();
            response[i].flight = json.getInt("flight_number");
            response[i].name = json.getString("mission_name");
            response[i].upcoming = json.getBoolean("upcoming");
            try {
                response[i].launch = json.getString("launch_date_utc");
            } catch (Exception e) {
                response[i].launch = "";
            }
            response[i].launchSite = json.getJSONObject("launch_site").getString("site_name_long");
            response[i].tentative = json.getBoolean("is_tentative");
            response[i].tentPrec = json.getString("tentative_max_precision");
            response[i].tbd = json.getBoolean("tbd");
            try {
                response[i].rockName = json.getJSONObject("rocket_name").getString("rocket_name");
            } catch (Exception e) {
                response[i].rockName = "";
            }
            try {
                response[i].rockType = json.getJSONObject("rocket_type").getString("rocket_type");
            } catch (Exception e) {
                response[i].rockType = "";
            }
            try {
                response[i].success = json.getBoolean("launch_success");
            } catch (Exception e) {
                response[i].success = null;
            }
            try {
                response[i].details = json.getString("details");
            } catch (Exception e) {
                response[i].details = "";
            }
        }
        model.addAttribute("launches", response);
        return "Launch";
    }
}

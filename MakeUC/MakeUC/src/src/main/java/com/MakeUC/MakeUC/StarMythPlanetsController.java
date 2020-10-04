import com.MakeUC.MakeUC.MakeUcApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StarMythPlanetsController {

    public static void main(String[] args) {
        SpringApplication.run(MakeUcApplication.class, args);
    }

    @RequestMapping("/Planets")
    public String home() {
        return "StarMythPlanets";
    }

    @GetMapping("/Planets/search")
    public String search_stuff(@RequestParam(value = "type") String type) {
        return "StarSearch";
    }
}
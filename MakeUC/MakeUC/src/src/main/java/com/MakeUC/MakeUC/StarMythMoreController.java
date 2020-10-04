import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StarMythMoreController {

    public static void main(String[] args) {
        SpringApplication.run(com.MakeUC.MakeUC.MakeUcApplication.class, args);
    }

    @RequestMapping("/MoreStars")
    public String home() {
        return "StarMythOtherCons";
    }

    @GetMapping("/MoreStars/search")
    public String search_stuff(@RequestParam(value = "type") String type) {
        return "StarSearch";
    }
}
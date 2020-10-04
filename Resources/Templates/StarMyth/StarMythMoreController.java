@Controller
public class StarMyth{

    public static void main(String[] args) {
        SpringApplication.run(MakeUcApplication.class, args);
    }

    @RequestMapping("/MoreStars")
    public String home() {
        return "StarMythOtherCons";
    }

    @GetMapping("/MoreStars/search")
    public String search_stuff(@RequestParam(value="type") String type) {
        return "StarSearch";
    }
}
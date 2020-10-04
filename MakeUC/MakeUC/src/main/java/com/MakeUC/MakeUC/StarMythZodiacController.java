@Controller
public class StarMyth{

    public static void main(String[] args) {
        SpringApplication.run(MakeUcApplication.class, args);
    }

    @RequestMapping("/Zodiac")
    public String home() {
        return "StarMythZodiac";
    }

    @GetMapping("/Zodiac/search")
    public String search_stuff(@RequestParam(value="type") String type) {
        return "StarSearch";
    }
}
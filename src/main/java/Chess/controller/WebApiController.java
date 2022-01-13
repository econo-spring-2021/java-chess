package Chess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebApiController {

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }
}

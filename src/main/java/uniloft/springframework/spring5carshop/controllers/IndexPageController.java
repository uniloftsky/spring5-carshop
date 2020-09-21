package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageController {

    @RequestMapping({"", "/", "index", "index.html", "home", "home.html"})
    public String getIndexPage() {
        return "index";
    }

}

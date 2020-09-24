package uniloft.springframework.spring5carshop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.spring5carshop.services.CarTypeService;

@AllArgsConstructor
@Controller
public class IndexPageController {

    private final CarTypeService carTypeService;

    @RequestMapping({"", "/", "index", "index.html", "home", "home.html"})
    public String getIndexPage(Model model) {
        model.addAttribute("carTypes", carTypeService.getCarTypes());
        return "index";
    }

}

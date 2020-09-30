package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.spring5carshop.services.CarTypeService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class IndexPageController {

    private final CarTypeService carTypeService;

    public IndexPageController(CarTypeService carTypeService) {
        this.carTypeService = carTypeService;
    }

    @RequestMapping({"", "/", "index", "index.html", "home", "home.html"})
    public String getIndexPage(Model model) {
        model.addAttribute("carTypes", carTypeService.getCarTypes());
        model.addAttribute("currentDate", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        return "index";
    }

}

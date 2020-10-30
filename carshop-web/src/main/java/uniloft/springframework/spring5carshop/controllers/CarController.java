package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uniloft.springframework.spring5carshop.services.CarService;

@Controller
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("catalog/car/{carId}")
    public String getCar(@PathVariable Long carId, Model model) {
        model.addAttribute("car", carService.findById(carId));
        return "car/show";
    }
}

package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.services.CarService;
import uniloft.springframework.spring5carshop.services.CarTypeService;
import uniloft.springframework.spring5carshop.services.ColorService;
import uniloft.springframework.spring5carshop.services.repositories.CarRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Controller
public class IndexPageController {

    private final CarTypeService carTypeService;
    private final CarService carService;
    private final CarRepository carRepository;
    private final ColorService colorService;

    public IndexPageController(CarTypeService carTypeService, CarService carService, CarRepository carRepository, ColorService colorService) {
        this.carTypeService = carTypeService;
        this.carService = carService;
        this.carRepository = carRepository;
        this.colorService = colorService;
    }

    @RequestMapping({"", "/", "index", "index.html", "home", "home.html"})
    public String getIndexPage(Model model) {
        model.addAttribute("carTypes", carTypeService.getCarTypes());
        model.addAttribute("currentDate", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        model.addAttribute("cars", carService.getCars());
        model.addAttribute("colors", colorService.getColors());
        model.addAttribute("carCount", carService.getCarsCount());
        return "index";
    }

    @GetMapping("car/{id}/show")
    public String showCar(@PathVariable String id, Model model) {
        model.addAttribute("car", carService.findById(Long.valueOf(id)));
        return "car/show";
    }

    @GetMapping("car/foundedlist/cartype/{id}")
    public String foundedListCar(@PathVariable String id, Model model) {
        model.addAttribute("cars", carRepository.findCarsByCarType_Id(Long.valueOf(id)));
        return "car/list";
    }

    /*@PostMapping("findCar")
    public String findCar(@RequestParam String brandName, @RequestParam String bodyName, @RequestParam String modelName, @RequestParam EngineType engineType, Model model) {
        Optional<Car> carOptional = carRepository.findCarByBrandNameAndModelNameAndBodyNameAndEngine_Type(brandName, modelName, bodyName, engineType);
        Car foundedCar = carOptional.get();
        return "redirect:/car/" + foundedCar.getId() + "/show";
    }*/

    @PostMapping("findCar")
    public String findCar(@RequestParam String carType) {
        Set<Car> foundedCars = carRepository.findCarsByCarType_Id(Long.valueOf(carType));
        return "redirect:/car/foundedlist/cartype/" + carType;
    }

}

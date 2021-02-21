package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniloft.springframework.spring5carshop.comparators.CarDescendingComparatorById;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.Message;
import uniloft.springframework.spring5carshop.services.*;
import uniloft.springframework.spring5carshop.services.repositories.CarRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Controller
public class IndexPageController {

    private final CarTypeService carTypeService;
    private final CarService carService;
    private final CarRepository carRepository;
    private final ColorService colorService;
    private final CarBrandService carBrandService;
    private final MessageService messageService;

    public IndexPageController(CarTypeService carTypeService, CarService carService, CarRepository carRepository, ColorService colorService, CarBrandService carBrandService, MessageService messageService) {
        this.carTypeService = carTypeService;
        this.carService = carService;
        this.carRepository = carRepository;
        this.colorService = colorService;
        this.carBrandService = carBrandService;
        this.messageService = messageService;
    }

    @GetMapping({"", "/", "index", "index.html", "home", "home.html"})
    public String getIndexPage(Model model) {
        model.addAttribute("carTypes", carTypeService.getCarTypes());
        model.addAttribute("colors", colorService.getColors());
        model.addAttribute("brands", carBrandService.getCarBrands());
        model.addAttribute("models", carBrandService.getBrandModels());
        model.addAttribute("bodies", carBrandService.getModelBodies());
        return "index";
    }

    @ModelAttribute("carCount")
    public Long getCarsCount() {
        return carService.getCarsCount();
    }

    @ModelAttribute("cars")
    public Set<Car> getCars() {
        return carService.getCars();
    }

    @ModelAttribute("featuredCars")
    public Set<Car> getFeaturedCars() {
        return carService.getCars().stream().limit(3).collect(Collectors.toSet());
    }

    @ModelAttribute("recentCars")
    public Set<Car> getRecentCars() {
        Comparator<Car> comparator = new CarDescendingComparatorById();
        Set<Car> sortedSet = carService.getSortedCars(comparator).stream().limit(3).collect(Collectors.toSet());
        TreeSet<Car> finalSet = new TreeSet<>(comparator);
        sortedSet.stream().iterator().forEachRemaining(finalSet::add);
        return finalSet;
    }

    @ModelAttribute("currentDate")
    public String getCurrentDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
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

    @GetMapping("about")
    public String getAboutPage() {
        return "about";
    }

    @GetMapping("contact")
    public String getContactPage() {
        return "contact";
    }

    @PostMapping("/messageAdd")
    public String messageAdd(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("phone") String phone, @RequestParam("comment") String comment) {
        Message message = new Message();
        messageService.save(message, name, email, phone, comment);
        return "redirect:/index";
    }
}


package uniloft.springframework.spring5carshop.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uniloft.springframework.spring5carshop.comparators.CarDescendingComparatorById;
import uniloft.springframework.spring5carshop.model.BuyCar;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.Customer;
import uniloft.springframework.spring5carshop.model.TestCar;
import uniloft.springframework.spring5carshop.services.BuyCarService;
import uniloft.springframework.spring5carshop.services.CarService;
import uniloft.springframework.spring5carshop.services.CustomerService;
import uniloft.springframework.spring5carshop.services.TestCarService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class CarController {

    private final CarService carService;
    private final CustomerService customerService;
    private final BuyCarService buyCarService;
    private final TestCarService testCarService;

    public CarController(CarService carService, CustomerService customerService, BuyCarService buyCarService, TestCarService testCarService) {
        this.carService = carService;
        this.customerService = customerService;
        this.buyCarService = buyCarService;
        this.testCarService = testCarService;
    }

    @GetMapping("catalog/car/{carId}")
    public String getCar(@PathVariable Long carId, Model model) {
        model.addAttribute("car", carService.findById(carId));
        return "car/show";
    }

    @GetMapping("catalog/car/{carId}/buy")
    public String buyCar(@PathVariable Long carId, Model model) {
        model.addAttribute("operation", "Покупка автомобіля");
        model.addAttribute("car", carService.findById(carId));
        model.addAttribute("customer", new Customer());
        return "car/order";
    }

    @GetMapping("catalog/car/{carId}/test")
    public String testCar(@PathVariable Long carId, Model model) {
        model.addAttribute("car", carService.findById(carId));
        model.addAttribute("operation", "Тест-драйв автомобіля");
        model.addAttribute("customer", new Customer());
        return "car/order";
    }

    @PostMapping("catalog/car/{carId}/testCar")
    public String processTestCarForm(RedirectAttributes rA, @PathVariable Long carId, @Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        Car foundCar = carService.findById(carId);

        if (bindingResult.hasErrors()) {
            model.addAttribute("car", foundCar);
            model.addAttribute("operation", "Тест-драйв автомобіля");
            return "car/order";
        }

        customerService.saveOrUpdate(customer);
        TestCar testCar = new TestCar();
        testCarService.save(testCar, customer, foundCar);
        rA.addFlashAttribute("success", "Ви успішно записались на тест-драйв!");
        return "redirect:/catalog/car/" + carId + "/test";
    }

    @PostMapping("catalog/car/{carId}/buyCar")
    public String processBuyCarForm(RedirectAttributes rA, @PathVariable Long carId, @Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {
        Car foundCar = carService.findById(carId);
        if (bindingResult.hasErrors()) {
            model.addAttribute("car", foundCar);
            model.addAttribute("operation", "Покупка автомобіля");
            return "car/order";
        }
        customerService.saveOrUpdate(customer);
        BuyCar buyCar = new BuyCar();
        buyCarService.save(buyCar, customer, foundCar);
        rA.addFlashAttribute("success", "Ви успішно придбали авто!");
        return "redirect:/catalog/car/" + carId + "/buy";
    }

    @ModelAttribute("recentVehicles")
    public Set<Car> getRecentVehicles() {
        Comparator<Car> comparator = new CarDescendingComparatorById();
        Set<Car> sortedSet = carService.getSortedCars(comparator).stream().limit(4).collect(Collectors.toSet());
        TreeSet<Car> finalSet = new TreeSet<>(comparator);
        sortedSet.stream().iterator().forEachRemaining(finalSet::add);
        return finalSet;
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
}

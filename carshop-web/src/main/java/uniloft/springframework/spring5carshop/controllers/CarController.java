package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import uniloft.springframework.spring5carshop.comparators.CarDescendingComparatorById;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.services.CarService;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

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

    @ModelAttribute("recentVehicles")
    public Set<Car> getRecentVehicles() {
        Comparator<Car> comparator = new CarDescendingComparatorById();
        Set<Car> sortedSet = carService.getSortedCars(comparator).stream().limit(4).collect(Collectors.toSet());
        TreeSet<Car> finalSet = new TreeSet<>(comparator);
        sortedSet.stream().iterator().forEachRemaining(finalSet::add);
        return finalSet;
    }
}

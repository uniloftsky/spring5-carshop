package uniloft.springframework.spring5carshop.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.spring5carshop.comparators.CarDescendingComparatorImpl;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.CarBody;
import uniloft.springframework.spring5carshop.model.CarBrand;
import uniloft.springframework.spring5carshop.model.CarModel;
import uniloft.springframework.spring5carshop.services.CarBrandService;
import uniloft.springframework.spring5carshop.services.CarService;
import uniloft.springframework.spring5carshop.services.CarTypeService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@RequestMapping("/catalog")
@Controller
public class CatalogController {

    private final CarService carService;
    private final CarBrandService carBrandService;
    private final CarTypeService carTypeService;

    public CatalogController(CarService carService, CarBrandService carBrandService, CarTypeService carTypeService) {
        this.carService = carService;
        this.carBrandService = carBrandService;
        this.carTypeService = carTypeService;
    }

    @RequestMapping({"index", "", "/"})
    public String getCatalogPage(Model model, @PageableDefault(sort = {"brand.brandName"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Car> pages = carService.findAll(pageable);
        Integer maxPage = pages.getTotalPages();
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("page", pages);
        List<Integer> pageNumbers = IntStream.rangeClosed(1, pages.getTotalPages()).boxed().collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("currentPage", pages.getNumber());
        return "catalog/index";
    }

    @ModelAttribute("brands")
    public Set<CarBrand> getBrands() {
        return carBrandService.getBrands();
    }

    @ModelAttribute("currentDate")
    public String getCurrentDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @ModelAttribute("models")
    public Set<CarModel> getModels() {
        return carBrandService.getBrandModels();
    }

    @ModelAttribute("bodies")
    public Set<CarBody> getBodies() {
        return carBrandService.getModelBodies();
    }

    @ModelAttribute("featuredCars")
    public Set<Car> getFeaturedCars() {
        return carService.getCars().stream().limit(3).collect(Collectors.toSet());
    }

    @ModelAttribute("recentCars")
    public TreeSet<Car> getRecentCars() {
        Comparator<Car> comparator = new CarDescendingComparatorImpl();
        Set<Car> sortedSet = carService.getSortedCars(comparator).stream().limit(3).collect(Collectors.toSet());
        TreeSet<Car> finalSet = new TreeSet<>(comparator);
        sortedSet.stream().iterator().forEachRemaining(finalSet::add);
        return finalSet;
    }

}

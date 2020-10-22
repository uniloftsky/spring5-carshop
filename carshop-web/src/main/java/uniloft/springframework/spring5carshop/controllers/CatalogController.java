package uniloft.springframework.spring5carshop.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uniloft.springframework.spring5carshop.comparators.CarDescendingComparatorById;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.CarBody;
import uniloft.springframework.spring5carshop.model.CarBrand;
import uniloft.springframework.spring5carshop.model.CarModel;
import uniloft.springframework.spring5carshop.services.CarBrandService;
import uniloft.springframework.spring5carshop.services.CarService;
import uniloft.springframework.spring5carshop.services.CarTypeService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
    public String getCatalogPage(Model model, @PageableDefault(sort = {"brand.brandName"}, direction = Sort.Direction.ASC, size = 5, page = 0) Pageable pageable) {
        Page<Car> pages = carService.findAll(pageable);
        Integer maxPage = pages.getTotalPages();
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("page", pages);
        List<Integer> pageNumbers = IntStream.rangeClosed(1, pages.getTotalPages()).boxed().collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("currentPage", pages.getNumber());
        return "catalog/index";
    }

    @PostMapping("/filterCars")
    public String getFoundedCars(Model model, @RequestParam String brandName, @RequestParam String modelName, @RequestParam String bodyName) {
        Set<Car> foundedCars = new HashSet<>();
        String newBrandName, newModelName, newBodyName;
        if(brandName.equals("allBrands") && modelName.equals("allModels") && bodyName.equals("allBodies")) {
            foundedCars = carService.getCars();
        }
        if(!brandName.equals("allBrands")) {
            newBrandName = brandName.substring(10, brandName.length());
            foundedCars = carService.findCarsByBrand_BrandName(newBrandName);
        }
        if(!brandName.equals("allBrands") && !modelName.equals("allModels")) {
            newBrandName = brandName.substring(10, brandName.length());
            newModelName = modelName.substring(10, modelName.length());
            foundedCars = carService.findCarsByBrand_BrandNameAndModel_ModelName(newBrandName, newModelName);
            System.out.println(newBrandName + " " + newModelName + " ");
        }
        if(!brandName.equals("allBrands") && !modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newBrandName = brandName.substring(10, brandName.length());
            newModelName = modelName.substring(10, modelName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            foundedCars = carService.findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(newBrandName, newModelName, newBodyName);
        }
        //System.out.println(brandName + " " + modelName + " " + bodyName);
        /*else if(!brandName.equals("allBrands") && !modelName.equals("allModels")) {

        }*/
        /*else if(brandName.equals("allBrands")) {
            foundedCars = carService.findCarsByModel_ModelNameAndBody_BodyName(modelName, bodyName);
        }*/
        model.addAttribute("foundedCars", foundedCars);
        return "catalog/list";
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

    @ModelAttribute("minPrice")
    public BigDecimal getMinPrice() {
        return carService.findMinPrice();
    }

    @ModelAttribute("maxPrice")
    public BigDecimal getMaxPrice() {
        return carService.findMaxPrice();
    }

    @ModelAttribute("recentCars")
    public TreeSet<Car> getRecentCars() {
        Comparator<Car> comparator = new CarDescendingComparatorById();
        Set<Car> sortedSet = carService.getSortedCars(comparator).stream().limit(3).collect(Collectors.toSet());
        TreeSet<Car> finalSet = new TreeSet<>(comparator);
        sortedSet.stream().iterator().forEachRemaining(finalSet::add);
        return finalSet;
    }

}

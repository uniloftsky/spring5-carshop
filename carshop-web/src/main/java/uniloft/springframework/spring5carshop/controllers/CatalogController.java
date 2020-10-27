package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uniloft.springframework.spring5carshop.comparators.CarDescendingComparatorById;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.CarBody;
import uniloft.springframework.spring5carshop.model.CarBrand;
import uniloft.springframework.spring5carshop.model.CarModel;
import uniloft.springframework.spring5carshop.services.CarBrandService;
import uniloft.springframework.spring5carshop.services.CarService;
import uniloft.springframework.spring5carshop.services.CarTypeService;
import uniloft.springframework.spring5carshop.services.repositories.CarRepository;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

//@SessionAttributes({"page", "pageNumbers", "currentPage"})
@RequestMapping("/catalog")
@Controller
public class CatalogController {

    private final CarService carService;
    private final CarBrandService carBrandService;
    private final CarTypeService carTypeService;
    private final CarRepository carRepository;

    public CatalogController(CarService carService, CarBrandService carBrandService, CarTypeService carTypeService, CarRepository carRepository) {
        this.carService = carService;
        this.carBrandService = carBrandService;
        this.carTypeService = carTypeService;
        this.carRepository = carRepository;
    }

    @RequestMapping({"index", "", "/"})
    public String getCatalogPage(RedirectAttributes redirectAttributes, Model model) {
        return "catalog/index";
    }

    @ModelAttribute("minSelectedPrice")
    public BigDecimal getMinSelectedPrice() {
        return carService.findMinPrice();
    }

    @ModelAttribute("maxSelectedPrice")
    public BigDecimal getMaxSelectedPrice() {
        return carService.findMaxPrice();
    }

    @PostMapping
    @RequestMapping("/filterCars")
    public String getFoundedCars(HttpSession httpSession, RedirectAttributes ra, Model model, @RequestParam String brandName, @RequestParam String modelName, @RequestParam String bodyName, @RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice) {
        String newBrandName, newModelName, newBodyName;
        Integer maxPage;
        Set<Car> filterCars = carService.findCars(minPrice, maxPrice);
        List<Integer> pageNumbers = null;
        int currentPage = 0;

        if (brandName.equals("allBrands") && modelName.equals("allModels") && bodyName.equals("allBodies")) {
            filterCars = carService.findCars(minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!brandName.equals("allBrands")) {
            newBrandName = brandName.substring(10, brandName.length());
            String[] carsTest = newBrandName.split(",");
            List<String> cars = new ArrayList<>(Arrays.asList(carsTest));
            filterCars = carService.findCarsByBrand_BrandName(cars, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }

        if (!brandName.equals("allBrands") && !modelName.equals("allModels")) {
            newBrandName = brandName.substring(10, brandName.length());
            newModelName = modelName.substring(10, modelName.length());
            List<String> brandList, modelList;
            String[] brands = newBrandName.split(",");
            String[] models = newModelName.split(",");
            brandList = new ArrayList<>(Arrays.asList(brands));
            modelList = new ArrayList<>(Arrays.asList(models));
            filterCars = carService.findCarsByBrand_BrandNameAndModel_ModelName(brandList, modelList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!brandName.equals("allBrands") && !modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newBrandName = brandName.substring(10, brandName.length());
            newModelName = modelName.substring(10, modelName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> brandList, modelList, bodyList;
            String[] brands = newBrandName.split(",");
            String[] models = newModelName.split(",");
            String[] bodies = newBodyName.split(",");
            brandList = new ArrayList<>(Arrays.asList(brands));
            modelList = new ArrayList<>(Arrays.asList(models));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            filterCars = carService.findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(brandList, modelList, bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (brandName.equals("allBrands") && !modelName.equals("allModels")) {
            newModelName = modelName.substring(10, modelName.length());
            List<String> modelList;
            String[] models = newModelName.split(",");
            modelList = new ArrayList<>(Arrays.asList(models));
            filterCars = carService.findCarsByModel_ModelName(modelList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (brandName.equals("allBrands") && modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> bodyList;
            String[] bodies = newBodyName.split(",");
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            filterCars = carService.findCarsByBody_BodyName(bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (brandName.equals("allBrands") && !modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newModelName = modelName.substring(10, modelName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> modelList, bodyList;
            String[] models = newModelName.split(",");
            String[] bodies = newBodyName.split(",");
            modelList = new ArrayList<>(Arrays.asList(models));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            filterCars = carService.findCarsByModel_ModelNameAndBody_BodyName(modelList, bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!brandName.equals("allBrands") && modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newBrandName = brandName.substring(10, brandName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> brandList, bodyList;
            String[] brands = newBrandName.split(",");
            String[] bodies = newBodyName.split(",");
            brandList = new ArrayList<>(Arrays.asList(brands));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            System.out.println(newBodyName);
            filterCars = carService.findCarsByBrand_BrandNameAndBody_BodyName(brandList, bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        ra.addFlashAttribute("page", filterCars);
        ra.addFlashAttribute("minSelectedPrice", minPrice);
        ra.addFlashAttribute("maxSelectedPrice", maxPrice);
        return "redirect:/catalog";
    }

    @ModelAttribute("page")
    public Set<Car> getAllCarsPage(HttpSession httpSession, Model model) {
        Set<Car> filterCars = carService.findAll();
        model.addAttribute("page", filterCars);
        return filterCars;
    }

    @ModelAttribute("brands")
    public Set<CarBrand> getBrands() {
        return carBrandService.getCarBrands();
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

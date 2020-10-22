package uniloft.springframework.spring5carshop.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

import java.math.BigDecimal;
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
    public String getCatalogPage(RedirectAttributes redirectAttributes, Model model) {
        return "catalog/index";
    }

    @ModelAttribute("page")
    public Page<Car> getAllCarsPage(Model model, @PageableDefault(sort = {"brand.brandName"}, direction = Sort.Direction.ASC, size = 5, page = 0) Pageable pageable) {
        Page<Car> foundedCars = carService.findAll(pageable);
        Integer maxPage = foundedCars.getTotalPages();
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("page", foundedCars);
        List<Integer> pageNumbers = IntStream.rangeClosed(1, foundedCars.getTotalPages()).boxed().collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("currentPage", foundedCars.getNumber());
        return foundedCars;
    }


    @RequestMapping("/filterCars")
    public String getFoundedCars(RedirectAttributes ra, Model model, @RequestParam String brandName, @RequestParam String modelName, @RequestParam String bodyName, @PageableDefault(sort = {"brand.brandName"}, direction = Sort.Direction.ASC, size = 5, page = 0) Pageable pageable) {
        Page<Car> foundedCars = null;
        String newBrandName, newModelName, newBodyName;
        Integer maxPage;

        if(brandName.equals("allBrands") && modelName.equals("allModels") && bodyName.equals("allBodies")) {
            foundedCars = carService.findAll(pageable);
            maxPage = foundedCars.getTotalPages();
            ra.addFlashAttribute("maxPage", maxPage);
            ra.addFlashAttribute("page", foundedCars);
            List<Integer> pageNumbers = IntStream.rangeClosed(1, foundedCars.getTotalPages()).boxed().collect(Collectors.toList());
            ra.addFlashAttribute("pageNumbers", pageNumbers);
            ra.addFlashAttribute("currentPage", foundedCars.getNumber());
        }
        if(!brandName.equals("allBrands")) {
            newBrandName = brandName.substring(10, brandName.length());
            foundedCars = carService.findCarsByBrand_BrandName(newBrandName, pageable);
            maxPage = foundedCars.getTotalPages();
            ra.addFlashAttribute("maxPage", maxPage);
            ra.addFlashAttribute("page", foundedCars);
            List<Integer> pageNumbers = IntStream.rangeClosed(1, foundedCars.getTotalPages()).boxed().collect(Collectors.toList());
            ra.addFlashAttribute("pageNumbers", pageNumbers);
            ra.addFlashAttribute("currentPage", foundedCars.getNumber());
        }
        if(!brandName.equals("allBrands") && !modelName.equals("allModels")) {
            newBrandName = brandName.substring(10, brandName.length());
            newModelName = modelName.substring(10, modelName.length());
            foundedCars = carService.findCarsByBrand_BrandNameAndModel_ModelName(newBrandName, newModelName, pageable);
            maxPage = foundedCars.getTotalPages();
            ra.addFlashAttribute("maxPage", maxPage);
            ra.addFlashAttribute("page", foundedCars);
            List<Integer> pageNumbers = IntStream.rangeClosed(1, foundedCars.getTotalPages()).boxed().collect(Collectors.toList());
            ra.addFlashAttribute("pageNumbers", pageNumbers);
            ra.addFlashAttribute("currentPage", foundedCars.getNumber());
        }
        if(!brandName.equals("allBrands") && !modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newBrandName = brandName.substring(10, brandName.length());
            newModelName = modelName.substring(10, modelName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            foundedCars = carService.findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(newBrandName, newModelName, newBodyName, pageable);
            maxPage = foundedCars.getTotalPages();
            ra.addFlashAttribute("maxPage", maxPage);
            ra.addFlashAttribute("page", foundedCars);
            List<Integer> pageNumbers = IntStream.rangeClosed(1, foundedCars.getTotalPages()).boxed().collect(Collectors.toList());
            ra.addFlashAttribute("pageNumbers", pageNumbers);
            ra.addFlashAttribute("currentPage", foundedCars.getNumber());
        }
        if(brandName.equals("allBrands") && !modelName.equals("allModels")) {
            newModelName = modelName.substring(10, modelName.length());
            foundedCars = carService.findCarsByModel_ModelName(newModelName, pageable);
            maxPage = foundedCars.getTotalPages();
            ra.addFlashAttribute("maxPage", maxPage);
            ra.addFlashAttribute("page", foundedCars);
            List<Integer> pageNumbers = IntStream.rangeClosed(1, foundedCars.getTotalPages()).boxed().collect(Collectors.toList());
            ra.addFlashAttribute("pageNumbers", pageNumbers);
            ra.addFlashAttribute("currentPage", foundedCars.getNumber());
        }
        if(brandName.equals("allBrands") && modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newBodyName = bodyName.substring(10, bodyName.length());
            foundedCars = carService.findCarsByBody_BodyName(newBodyName, pageable);
            maxPage = foundedCars.getTotalPages();
            ra.addFlashAttribute("maxPage", maxPage);
            ra.addFlashAttribute("page", foundedCars);
            List<Integer> pageNumbers = IntStream.rangeClosed(1, foundedCars.getTotalPages()).boxed().collect(Collectors.toList());
            ra.addFlashAttribute("pageNumbers", pageNumbers);
            ra.addFlashAttribute("currentPage", foundedCars.getNumber());
        }
        if(brandName.equals("allBrands") && !modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newModelName = modelName.substring(10, modelName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            foundedCars = carService.findCarsByModel_ModelNameAndBody_BodyName(newModelName, newBodyName, pageable);
            maxPage = foundedCars.getTotalPages();
            ra.addFlashAttribute("maxPage", maxPage);
            ra.addFlashAttribute("page", foundedCars);
            List<Integer> pageNumbers = IntStream.rangeClosed(1, foundedCars.getTotalPages()).boxed().collect(Collectors.toList());
            ra.addFlashAttribute("pageNumbers", pageNumbers);
            ra.addFlashAttribute("currentPage", foundedCars.getNumber());
        }
        if(!brandName.equals("allBrands") && modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newBrandName = brandName.substring(10, brandName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            foundedCars = carService.findCarsByBrand_BrandNameAndBody_BodyName(newBrandName, newBodyName, pageable);
            maxPage = foundedCars.getTotalPages();
            ra.addFlashAttribute("maxPage", maxPage);
            ra.addFlashAttribute("page", foundedCars);
            List<Integer> pageNumbers = IntStream.rangeClosed(1, foundedCars.getTotalPages()).boxed().collect(Collectors.toList());
            ra.addFlashAttribute("pageNumbers", pageNumbers);
            ra.addFlashAttribute("currentPage", foundedCars.getNumber());
        }

        ra.addFlashAttribute("page", foundedCars);
        return "redirect:/catalog";
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

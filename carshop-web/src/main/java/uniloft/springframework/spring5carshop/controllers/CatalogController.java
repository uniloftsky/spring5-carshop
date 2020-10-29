package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uniloft.springframework.spring5carshop.comparators.CarDescendingComparatorById;
import uniloft.springframework.spring5carshop.model.*;
import uniloft.springframework.spring5carshop.services.CarBrandService;
import uniloft.springframework.spring5carshop.services.CarService;
import uniloft.springframework.spring5carshop.services.CarTypeService;
import uniloft.springframework.spring5carshop.services.repositories.CarRepository;

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

    @GetMapping("/filterCars")
    public String getFoundedCars(Model model, @RequestParam String brandName, @RequestParam String modelName, @RequestParam String bodyName, @RequestParam String engineType, @RequestParam String carType, @RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice) {
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
            filterCars = carService.findCarsByBrand_BrandNameAndBody_BodyName(brandList, bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!engineType.equals("allEngines")) {
            List<String> engineList;
            String[] engines = engineType.split(",");
            engineList = new ArrayList<>(Arrays.asList(engines));
            filterCars = carService.findCarsByEngine_Type_Description(engineList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!engineType.equals("allEngines") && !brandName.equals("allBrands")) {
            newBrandName = brandName.substring(10, brandName.length());
            List<String> brandList, engineList;
            String[] brands = newBrandName.split(",");
            String[] engines = engineType.split(",");
            brandList = new ArrayList<>(Arrays.asList(brands));
            engineList = new ArrayList<>(Arrays.asList(engines));
            filterCars = carService.findCarsByEngine_Type_DescriptionAndBrand_BrandName(engineList, brandList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!engineType.equals("allEngines") && !modelName.equals("allModels")) {
            newModelName = modelName.substring(10, modelName.length());
            List<String> modelList, engineList;
            String[] models = newModelName.split(",");
            String[] engines = engineType.split(",");
            modelList = new ArrayList<>(Arrays.asList(models));
            engineList = new ArrayList<>(Arrays.asList(engines));
            filterCars = carService.findCarsByEngine_Type_DescriptionAndModel_ModelName(engineList, modelList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!engineType.equals("allEngines") && !bodyName.equals("allBodies")) {
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> bodyList, engineList;
            String[] bodies = newBodyName.split(",");
            String[] engines = engineType.split(",");
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            engineList = new ArrayList<>(Arrays.asList(engines));
            filterCars = carService.findCarsByEngine_Type_DescriptionAndBody_BodyName(engineList, bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!engineType.equals("allEngines") && !brandName.equals("allBrands") && !modelName.equals("allModels")) {
            newBrandName = brandName.substring(10, brandName.length());
            newModelName = modelName.substring(10, modelName.length());
            List<String> brandList, modelList, engineList;
            String[] brands = newBrandName.split(",");
            String[] models = newModelName.split(",");
            String[] engines = engineType.split(",");
            brandList = new ArrayList<>(Arrays.asList(brands));
            modelList = new ArrayList<>(Arrays.asList(models));
            engineList = new ArrayList<>(Arrays.asList(engines));
            filterCars = carService.findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndModel_ModelName(engineList, brandList, modelList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!engineType.equals("allEngines") && !brandName.equals("allBrands") && !bodyName.equals("allBodies")) {
            newBrandName = brandName.substring(10, brandName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> brandList, bodyList, engineList;
            String[] brands = newBrandName.split(",");
            String[] bodies = newBodyName.split(",");
            String[] engines = engineType.split(",");
            brandList = new ArrayList<>(Arrays.asList(brands));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            engineList = new ArrayList<>(Arrays.asList(engines));
            filterCars = carService.findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndBody_BodyName(engineList, brandList, bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!engineType.equals("allEngines") && !bodyName.equals("allBodies") && !modelName.equals("allModels")) {
            newModelName = modelName.substring(10, modelName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> modelList, bodyList, engineList;
            String[] models = newModelName.split(",");
            String[] bodies = newBodyName.split(",");
            String[] engines = engineType.split(",");
            modelList = new ArrayList<>(Arrays.asList(models));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            engineList = new ArrayList<>(Arrays.asList(engines));
            filterCars = carService.findCarsByEngine_Type_DescriptionAndModel_ModelNameAndBody_BodyName(engineList, modelList, bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!engineType.equals("allEngines") && !bodyName.equals("allBodies") && !modelName.equals("allModels") && !brandName.equals("allBrands")) {
            newBrandName = brandName.substring(10, brandName.length());
            newModelName = modelName.substring(10, modelName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> brandList, modelList, bodyList, engineList;
            String[] brands = newBrandName.split(",");
            String[] models = newModelName.split(",");
            String[] bodies = newBodyName.split(",");
            String[] engines = engineType.split(",");
            brandList = new ArrayList<>(Arrays.asList(brands));
            modelList = new ArrayList<>(Arrays.asList(models));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            engineList = new ArrayList<>(Arrays.asList(engines));
            filterCars = carService.findCarsByEngine_Type_DescriptionAndBrand_BrandNameAndBody_BodyNameAndModel_ModelName(engineList, brandList, modelList, bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!carType.equals("allTypes")) {
            String[] types = carType.split(",");
            List<String> typeList = new ArrayList<>(Arrays.asList(types));
            filterCars = carService.findCarsByCarType_TypeName(typeList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!carType.equals("allTypes") && !brandName.equals("allBrands")) {
            newBrandName = brandName.substring(10, brandName.length());
            List<String> brandList, typeList;
            String[] brands = newBrandName.split(",");
            String[] types = carType.split(",");
            typeList = new ArrayList<>(Arrays.asList(types));
            brandList = new ArrayList<>(Arrays.asList(brands));
            filterCars = carService.findCarsByCarType_TypeNameAndBrand_BrandName(typeList, brandList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!carType.equals("allTypes") && !modelName.equals("allModels")) {
            newModelName = modelName.substring(10, modelName.length());
            List<String> modelList, typeList;
            String[] models = newModelName.split(",");
            String[] types = carType.split(",");
            typeList = new ArrayList<>(Arrays.asList(types));
            modelList = new ArrayList<>(Arrays.asList(models));
            filterCars = carService.findCarsByCarType_TypeNameAndModel_ModelName(typeList, modelList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!carType.equals("allTypes") && !bodyName.equals("allBodies")) {
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> bodyList, typeList;
            String[] bodies = newBodyName.split(",");
            String[] types = carType.split(",");
            typeList = new ArrayList<>(Arrays.asList(types));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            filterCars = carService.findCarsByCarType_TypeNameAndBody_BodyName(typeList, bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!carType.equals("allTypes") && !brandName.equals("allBrands") && !modelName.equals("allModels")) {
            newBrandName = brandName.substring(10, brandName.length());
            newModelName = modelName.substring(10, modelName.length());
            List<String> brandList, modelList, typeList;
            String[] brands = newBrandName.split(",");
            String[] models = newModelName.split(",");
            String[] types = carType.split(",");
            typeList = new ArrayList<>(Arrays.asList(types));
            brandList = new ArrayList<>(Arrays.asList(brands));
            modelList = new ArrayList<>(Arrays.asList(models));
            filterCars = carService.findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelName(typeList, brandList, modelList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!carType.equals("allTypes") && !brandName.equals("allBrands") && !bodyName.equals("allBodies")) {
            newBrandName = brandName.substring(10, brandName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> brandList, bodyList, typeList;
            String[] brands = newBrandName.split(",");
            String[] bodies = newBodyName.split(",");
            String[] types = carType.split(",");
            typeList = new ArrayList<>(Arrays.asList(types));
            brandList = new ArrayList<>(Arrays.asList(brands));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            filterCars = carService.findCarsByCarType_TypeNameAndBrand_BrandNameAndBody_BodyName(typeList, brandList, bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!carType.equals("allTypes") && !modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newModelName = modelName.substring(10, modelName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            System.out.println(modelName + " " + bodyName);
            List<String> modelList, bodyList, typeList;
            String[] bodies = newBodyName.split(",");
            String[] models = newModelName.split(",");
            String[] types = carType.split(",");
            System.out.println("+++");
            typeList = new ArrayList<>(Arrays.asList(types));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            modelList = new ArrayList<>(Arrays.asList(models));
            filterCars = carService.findCarsByCarType_TypeNameAndModel_ModelNameAndBody_BodyName(typeList, modelList, bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if (!carType.equals("allTypes") && !brandName.equals("allBrands") && !modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newBrandName = brandName.substring(10, brandName.length());
            newModelName = modelName.substring(10, modelName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> brandList, modelList, bodyList, typeList;
            String[] brands = newBrandName.split(",");
            String[] bodies = newBodyName.split(",");
            String[] models = newModelName.split(",");
            String[] types = carType.split(",");
            brandList = new ArrayList<>(Arrays.asList(brands));
            typeList = new ArrayList<>(Arrays.asList(types));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            modelList = new ArrayList<>(Arrays.asList(models));
            filterCars = carService.findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndBody_BodyName(typeList, brandList, modelList, bodyList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if(!carType.equals("allTypes") && !engineType.equals("allEngines")) {
            List<String> engineList, typeList;
            String[] engines = engineType.split(",");
            String[] types = carType.split(",");
            engineList = new ArrayList<>(Arrays.asList(engines));
            typeList = new ArrayList<>(Arrays.asList(types));
            filterCars = carService.findCarsByCarType_TypeNameAndEngine_Type_Description(typeList, engineList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if(!carType.equals("allTypes") && !engineType.equals("allEngines") && !brandName.equals("allBrands")) {
            newBrandName = brandName.substring(10, brandName.length());
            List<String> brandList, engineList, typeList;
            String[] brands = newBrandName.split(",");
            String[] types = carType.split(",");
            String[] engines = engineType.split(",");
            engineList = new ArrayList<>(Arrays.asList(engines));
            brandList = new ArrayList<>(Arrays.asList(brands));
            typeList = new ArrayList<>(Arrays.asList(types));
            filterCars = carService.findCarsByCarType_TypeNameAndBrand_BrandNameAndEngine_Type_Description(typeList, brandList, engineList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if(!carType.equals("allTypes") && !engineType.equals("allEngines") && !modelName.equals("allModels")) {
            newModelName = modelName.substring(10, modelName.length());
            List<String> modelList, engineList, typeList;
            String[] models = newModelName.split(",");
            String[] types = carType.split(",");
            String[] engines = engineType.split(",");
            engineList = new ArrayList<>(Arrays.asList(engines));
            modelList = new ArrayList<>(Arrays.asList(models));
            typeList = new ArrayList<>(Arrays.asList(types));
            filterCars = carService.findCarsByCarType_TypeNameAndModel_ModelNameAndEngine_Type_Description(typeList, modelList, engineList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if(!carType.equals("allTypes") && !engineType.equals("allEngines") && !bodyName.equals("allBodies")) {
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> bodyList, engineList, typeList;
            String[] bodies = newBodyName.split(",");
            String[] types = carType.split(",");
            String[] engines = engineType.split(",");
            engineList = new ArrayList<>(Arrays.asList(engines));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            typeList = new ArrayList<>(Arrays.asList(types));
            filterCars = carService.findCarsByCarType_TypeNameAndBody_BodyNameAndEngine_Type_Description(typeList, bodyList, engineList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if(!carType.equals("allTypes") && !engineType.equals("allEngines") && !brandName.equals("allBrands") && !modelName.equals("allModels")) {
            newBrandName = brandName.substring(10, brandName.length());
            newModelName = modelName.substring(10, modelName.length());
            List<String> brandList, modelList, engineList, typeList;
            String[] brands = newBrandName.split(",");
            String[] models = newModelName.split(",");
            String[] types = carType.split(",");
            String[] engines = engineType.split(",");
            engineList = new ArrayList<>(Arrays.asList(engines));
            brandList = new ArrayList<>(Arrays.asList(brands));
            modelList = new ArrayList<>(Arrays.asList(models));
            typeList = new ArrayList<>(Arrays.asList(types));
            filterCars = carService.findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndEngine_Type_Description(typeList, brandList, modelList, engineList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if(!carType.equals("allTypes") && !engineType.equals("allEngines") && !brandName.equals("allBrands") && !bodyName.equals("allBodies")) {
            newBrandName = brandName.substring(10, brandName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> brandList, bodyList, engineList, typeList;
            String[] brands = newBrandName.split(",");
            String[] bodies = newBodyName.split(",");
            String[] types = carType.split(",");
            String[] engines = engineType.split(",");
            engineList = new ArrayList<>(Arrays.asList(engines));
            brandList = new ArrayList<>(Arrays.asList(brands));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            typeList = new ArrayList<>(Arrays.asList(types));
            filterCars = carService.findCarsByCarType_TypeNameAndBrand_BrandNameAndBody_BodyNameAndEngine_Type_Description(typeList, brandList, bodyList, engineList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if(!carType.equals("allTypes") && !engineType.equals("allEngines") && !modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newModelName = modelName.substring(10, modelName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> modelList, bodyList, engineList, typeList;
            String[] models = newModelName.split(",");
            String[] bodies = newBodyName.split(",");
            String[] types = carType.split(",");
            String[] engines = engineType.split(",");
            engineList = new ArrayList<>(Arrays.asList(engines));
            modelList = new ArrayList<>(Arrays.asList(models));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            typeList = new ArrayList<>(Arrays.asList(types));
            filterCars = carService.findCarsByCarType_TypeNameAndModel_ModelNameAndBody_BodyNameAndEngine_Type_Description(typeList, modelList, bodyList, engineList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        if(!carType.equals("allTypes") && !engineType.equals("allEngines") && !brandName.equals("allBrands") && !modelName.equals("allModels") && !bodyName.equals("allBodies")) {
            newBrandName = brandName.substring(10, brandName.length());
            newModelName = modelName.substring(10, modelName.length());
            newBodyName = bodyName.substring(10, bodyName.length());
            List<String> brandList, modelList, bodyList, engineList, typeList;
            String[] brands = newBrandName.split(",");
            String[] models = newModelName.split(",");
            String[] bodies = newBodyName.split(",");
            String[] types = carType.split(",");
            String[] engines = engineType.split(",");
            engineList = new ArrayList<>(Arrays.asList(engines));
            brandList = new ArrayList<>(Arrays.asList(brands));
            modelList = new ArrayList<>(Arrays.asList(models));
            bodyList = new ArrayList<>(Arrays.asList(bodies));
            typeList = new ArrayList<>(Arrays.asList(types));
            filterCars = carService.findCarsByCarType_TypeNameAndBrand_BrandNameAndModel_ModelNameAndBody_BodyNameAndEngine_Type_Description(typeList, brandList, modelList, bodyList, engineList, minPrice, maxPrice);
            model.addAttribute("page", filterCars);
        }
        model.addAttribute("minSelectedPrice", minPrice);
        model.addAttribute("maxSelectedPrice", maxPrice);
        return "catalog/index";
    }

    @ModelAttribute("page")
    public Set<Car> getAllCarsPage(Model model) {
        Set<Car> filterCars = carService.findAll();
        model.addAttribute("page", filterCars);
        return filterCars;
    }

    @ModelAttribute("brands")
    public Set<CarBrand> getBrands() {
        return carBrandService.getCarBrands();
    }

    @ModelAttribute("carTypes")
    public Set<CarType> getCarTypes() {
        return carTypeService.getCarTypes();
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

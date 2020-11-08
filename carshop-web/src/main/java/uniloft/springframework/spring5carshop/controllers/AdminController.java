package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uniloft.springframework.spring5carshop.comparators.CarAscendingComparatorById;
import uniloft.springframework.spring5carshop.comparators.CarBrandAscendingComparatorById;
import uniloft.springframework.spring5carshop.comparators.CarModelAscendingComparatorById;
import uniloft.springframework.spring5carshop.comparators.ColorAscendingComparatorById;
import uniloft.springframework.spring5carshop.model.*;
import uniloft.springframework.spring5carshop.services.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Controller
public class AdminController {

    private final ColorService colorService;
    private final CarBrandService carBrandService;
    private final CarTypeService carTypeService;
    private final CarService carService;
    private final ImageService imageService;

    private final String URL_ADMIN_REDIRECT = "redirect:/admin";

    public AdminController(ColorService colorService, CarBrandService carBrandService, CarTypeService carTypeService, CarService carService, ImageService imageService) {
        this.colorService = colorService;
        this.carBrandService = carBrandService;
        this.carTypeService = carTypeService;
        this.carService = carService;
        this.imageService = imageService;
    }

    @GetMapping("admin")
    public String getAdminPage() {
        return "redirect:/admin?page=cars";
    }

    @GetMapping(value = "/admin", params = "page")
    public String getAdminPageParam(@RequestParam String page, Model model) {
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping(value = "/admin", params = {"page=carEdit", "id"})
    public String getEditCarPage(@RequestParam String page, @RequestParam Long id, Model model) {
        model.addAttribute("car", carService.findById(id));
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping(value = "/admin", params = {"page=brandEdit", "id"})
    public String getEditBrandPage(@RequestParam String page, @RequestParam Long id, Model model) {
        model.addAttribute("brand", carBrandService.findCarBrandById(id));
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping(value = "/admin", params = {"page=newBrand"})
    public String getNewBrandPage(@RequestParam String page, Model model) {
        model.addAttribute("brand", new CarBrand());
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping("/admin/brandDelete/{id}")
    public String processDeleteBrand(@PathVariable Long id, Model model) {
        carBrandService.deleteBrand(carBrandService.findCarBrandById(id));
        return "redirect:/admin?page=brands";
    }

    @PostMapping(value = "/updateBrand")
    public String updateBrandProcessForm(@ModelAttribute CarBrand brand, Model model) {
        carBrandService.saveBrand(brand);
        return "redirect:/admin?page=brands";
    }

    @GetMapping(value = "/admin", params = {"page=modelEdit", "id"})
    public String getEditModelPage(@RequestParam String page, @RequestParam Long id, Model model) {
        model.addAttribute("model", carBrandService.findCarModelById(id));
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping(value = "/admin", params = {"page=newModel"})
    public String getNewModelPage(@RequestParam String page, Model model) {
        model.addAttribute("model", new CarModel());
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @PostMapping(value = "/updateModel")
    public String updateModelProcessForm(@ModelAttribute CarModel carModel, Model model) {
        carBrandService.saveModel(carModel);
        return "redirect:/admin?page=models";
    }

    @PostMapping("/editCar")
    public String updateCarProcessForm(@ModelAttribute Car car, @RequestParam(value = "imagefile", required = false) MultipartFile file, @RequestParam("changeImage") String changeImage) throws IOException {
        if(changeImage.equals("unchecked")) {
            carService.save(car);
        }
        else {
            imageService.saveImageFile(car, file);
        }
        return "redirect:/admin?page=carEdit&id=" + car.getId();
    }

    @ModelAttribute("cars")
    public TreeSet<Car> getSortedCars() {
        Comparator<Car> comparator = new CarAscendingComparatorById();
        TreeSet<Car> cars = new TreeSet<>(comparator);
        carService.getCars().iterator().forEachRemaining(cars::add);
        return cars;
    }

    @ModelAttribute("colors")
    public TreeSet<Color> getSortedColors() {
        Comparator<Color> comparator = new ColorAscendingComparatorById();
        TreeSet<Color> colors = new TreeSet<>(comparator);
        colorService.getColors().iterator().forEachRemaining(colors::add);
        return colors;
    }

    @ModelAttribute("brands")
    public Set<CarBrand> getSortedBrands() {
        Comparator<CarBrand> comparator = new CarBrandAscendingComparatorById();
        TreeSet<CarBrand> cars = new TreeSet<>(comparator);
        carBrandService.getCarBrands().iterator().forEachRemaining(cars::add);
        return cars;
    }

    @ModelAttribute("models")
    public Set<CarModel> getSortedModels() {
        Comparator<CarModel> comparator = new CarModelAscendingComparatorById();
        TreeSet<CarModel> cars = new TreeSet<>(comparator);
        carBrandService.getBrandModels().iterator().forEachRemaining(cars::add);
        return cars;
    }

    @ModelAttribute("bodies")
    public Set<CarBody> getSortedBodies() {
        return carBrandService.getModelBodies();
    }

    @ModelAttribute("carTypes")
    public Set<CarType> getSortedTypes() {
        return carTypeService.getCarTypes();
    }

    @PostMapping("admin/car/delete/{id}")
    public String carDeleteProcessForm(@PathVariable Long id) {
        Car foundCar = carService.findById(id);
        carService.deleteCar(foundCar);
        return URL_ADMIN_REDIRECT;
    }

    @PostMapping("colorAdd")
    public String colorAddProcessForm(@RequestParam String colorName) {
        Color color = new Color();
        color.setColor(colorName);
        colorService.save(color);
        return URL_ADMIN_REDIRECT;
    }

    @PostMapping("brandAdd")
    public String brandAddProcessForm(@RequestParam String brandName) {
        CarBrand carBrand = new CarBrand();
        carBrand.setBrandName(brandName);
        carBrandService.saveBrand(carBrand);
        return URL_ADMIN_REDIRECT;
    }
}

package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uniloft.springframework.spring5carshop.comparators.*;
import uniloft.springframework.spring5carshop.model.*;
import uniloft.springframework.spring5carshop.services.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private final EngineService engineService;
    private final CustomerService customerService;
    private final BuyCarService buyCarService;
    private final TestCarService testCarService;

    private final String URL_ADMIN_REDIRECT = "redirect:/admin";

    public AdminController(ColorService colorService, CarBrandService carBrandService, CarTypeService carTypeService, CarService carService, ImageService imageService, EngineService engineService, CustomerService customerService, BuyCarService buyCarService, TestCarService testCarService) {
        this.colorService = colorService;
        this.carBrandService = carBrandService;
        this.carTypeService = carTypeService;
        this.carService = carService;
        this.imageService = imageService;
        this.engineService = engineService;
        this.customerService = customerService;
        this.buyCarService = buyCarService;
        this.testCarService = testCarService;
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

    @GetMapping(value = "/admin", params = {"page=newCar"})
    public String getNewCarPage(@RequestParam String page, Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping(value = "/admin", params = {"page=carEdit", "id"})
    public String getEditCarPage(@RequestParam String page, @RequestParam Long id, Model model) {
        model.addAttribute("car", carService.findById(id));
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @PostMapping("/editCar")
    public String updateCarProcessForm(RedirectAttributes rA, @Valid @ModelAttribute Car car,  BindingResult bindingResult, @RequestParam(value = "imagefile", required = false) MultipartFile file, @RequestParam("changeImage") String changeImage) throws IOException {
        if(bindingResult.hasErrors()) {
            if(car.getId() == null) {
                rA.addFlashAttribute("errors", bindingResult.getAllErrors());
                return "redirect:/admin?page=newCar";
            }
            rA.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/admin?page=carEdit&id=" + car.getId();
        }
        if (changeImage.equals("unchecked")) {
            carService.save(car);
        } else {
            imageService.saveImageFile(car, file);
        }
        return "redirect:/admin?page=carEdit&id=" + car.getId();
    }

    @GetMapping("admin/car/delete/{id}")
    public String carDeleteProcessForm(@PathVariable Long id) {
        Car foundCar = carService.findById(id);
        carService.deleteCar(foundCar);
        return URL_ADMIN_REDIRECT;
    }

    //brands

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
    public String updateBrandProcessForm(RedirectAttributes rA, @Valid @ModelAttribute CarBrand brand, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            if(brand.getId() == null) {
                rA.addFlashAttribute("errors", bindingResult.getAllErrors());
                return "redirect:/admin?page=newBrand";
            }
            rA.addFlashAttribute("erros", bindingResult.getAllErrors());
            return "redirect:/admin?page=brandEdit&id=" + brand.getId();
        }
        carBrandService.saveBrand(brand);
        return "redirect:/admin?page=brands";
    }

    //models

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
    public String updateBodyProcessForm(RedirectAttributes rA, @Valid @ModelAttribute CarModel carModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            if (carModel.getId() == null) {
                rA.addFlashAttribute("erros", bindingResult.getAllErrors());
                return "redirect:/admin?page=newModel";
            }
            rA.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/admin?page=modelEdit&id=" + carModel.getId();
        }
        carBrandService.saveModel(carModel);
        return "redirect:/admin?page=models";
    }

    //bodies

    @GetMapping(value = "/admin", params = {"page=bodyEdit", "id"})
    public String getEditBodyPage(@RequestParam String page, @RequestParam Long id, Model model) {
        model.addAttribute("body", carBrandService.findCarBodyById(id));
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping(value = "/admin", params = {"page=newBody"})
    public String getNewBodyPage(@RequestParam String page, Model model) {
        model.addAttribute("body", new CarBody());
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @PostMapping(value = "/updateBody")
    public String updateBodyProcessForm(RedirectAttributes rA, @Valid @ModelAttribute CarBody carBody, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            if (carBody.getId() == null) {
                rA.addFlashAttribute("errors", bindingResult.getAllErrors());
                return "redirect:/admin?page=newBody";
            }
            rA.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/admin?page=bodyEdit&id=" + carBody.getId();
        }
        carBrandService.saveBody(carBody);
        return "redirect:/admin?page=bodies";
    }

    //types

    @GetMapping(value = "/admin", params = {"page=typeEdit", "id"})
    public String getEditTypePage(@RequestParam String page, @RequestParam Long id, Model model) {
        model.addAttribute("type", carTypeService.findById(id));
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping(value = "/admin", params = {"page=newType"})
    public String getNewTypePage(@RequestParam String page, Model model) {
        model.addAttribute("type", new CarType());
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping("/admin/typeDelete/{id}")
    public String processDeleteType(@PathVariable Long id, Model model) {
        carTypeService.delete(carTypeService.findById(id));
        return "redirect:/admin?page=carTypes";
    }

    @PostMapping(value = "/updateType")
    public String updateTypeProcessForm(RedirectAttributes rA, @Valid @ModelAttribute CarType carType, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            if (carType.getId() == null) {
                rA.addFlashAttribute("errors", bindingResult.getAllErrors());
                return "redirect:/admin?page=newType";
            }
            rA.addFlashAttribute("errors", bindingResult.getAllErrors());
            rA.addFlashAttribute("type", carType);
            return "redirect:/admin?page=typeEdit&id=" + carType.getId();
        }
        carTypeService.saveOrUpdate(carType);
        return "redirect:/admin?page=carTypes";
    }

    //colors

    @GetMapping(value = "/admin", params = {"page=colorEdit", "id"})
    public String getEditColorPage(@RequestParam String page, @RequestParam Long id, Model model) {
        model.addAttribute("color", colorService.findById(id));
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping(value = "/admin", params = {"page=newColor"})
    public String getNewColorPage(@RequestParam String page, Model model) {
        model.addAttribute("color", new Color());
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping("/admin/colorDelete/{id}")
    public String processDeleteColor(@PathVariable Long id, Model model) {
        colorService.delete(colorService.findById(id));
        return "redirect:/admin?page=colors";
    }

    @PostMapping(value = "/updateColor")
    public String updateColorProcessForm(RedirectAttributes rA, @Valid @ModelAttribute Color color, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            if (color.getId() == null) {
                rA.addFlashAttribute("errors", bindingResult.getAllErrors());
                return "redirect:/admin?page=newColor";
            }
            rA.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/admin?page=colorEdit&id=" + color.getId();
        }
        colorService.save(color);
        return "redirect:/admin?page=colors";
    }

    //engines

    @GetMapping(value = "/admin", params = {"page=engineEdit", "id"})
    public String getEditEnginePage(@RequestParam String page, @RequestParam Long id, Model model) {
        model.addAttribute("engine", engineService.findById(id));
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping(value = "/admin", params = {"page=newEngine"})
    public String getNewEnginePage(@RequestParam String page, Model model) {
        model.addAttribute("engine", new Engine());
        model.addAttribute("page", page);
        return "admin-panel/admin";
    }

    @GetMapping("/admin/engineDelete/{id}")
    public String processDeleteEngine(@PathVariable Long id, Model model) {
        engineService.delete(engineService.findById(id));
        return "redirect:/admin?page=engines";
    }

    @PostMapping(value = "/updateEngine")
    public String updateEngineProcessForm(RedirectAttributes rA, @Valid @ModelAttribute Engine engine, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            if (engine.getId() == null) {
                rA.addFlashAttribute("errors", bindingResult.getAllErrors());
                return "redirect:/admin?page=newEngine";
            }
            rA.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/admin?page=engineEdit&id=" + engine.getId();
        }
        engineService.save(engine);
        return "redirect:/admin?page=engines";
    }

    @ModelAttribute("engines")
    public TreeSet<Engine> getSortedEngines() {
        Comparator<Engine> comparator = new EngineAscendingComparatorById();
        TreeSet<Engine> engines = new TreeSet<>(comparator);
        engineService.getEngines().iterator().forEachRemaining(engines::add);
        return engines;
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
        Comparator<CarBody> comparator = new CarBodyAscendingComparatorById();
        TreeSet<CarBody> cars = new TreeSet<>(comparator);
        carBrandService.getModelBodies().iterator().forEachRemaining(cars::add);
        return cars;
    }

    @ModelAttribute("carTypes")
    public Set<CarType> getSortedTypes() {
        Comparator<CarType> comparator = new CarTypeAscendingComparatorById();
        TreeSet<CarType> types = new TreeSet<>(comparator);
        carTypeService.getCarTypes().iterator().forEachRemaining(types::add);
        return types;
    }

    @ModelAttribute("customers")
    public Set<Customer> getSortedCustomer() {
        Comparator<Customer> comparator = new CustomerAscendingComparatorById();
        TreeSet<Customer> customers = new TreeSet<>(comparator);
        customerService.getCustomers().iterator().forEachRemaining(customers::add);
        return customers;
    }

    @ModelAttribute("buys")
    public Set<BuyCar> getSortedBuys() {
        Comparator<BuyCar> comparator = new BuyCarAscendingComparatorById();
        TreeSet<BuyCar> buyCars = new TreeSet<>(comparator);
        buyCarService.getBuyCars().iterator().forEachRemaining(buyCars::add);
        return buyCars;
    }

    @ModelAttribute("tests")
    public Set<TestCar> getSortedTest() {
        Comparator<TestCar> comparator = new TestCarAscendingComparatorById();
        TreeSet<TestCar> testCars = new TreeSet<>(comparator);
        testCarService.getTestCars().iterator().forEachRemaining(testCars::add);
        return testCars;
    }

    @GetMapping("/createCustomersReport")
    public String createCustomerReport() throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-hh-mm-ss");
        File uploadPath = new File("reports");
        if(!uploadPath.exists()) {
            uploadPath.mkdir();
        }
        String fileName = uploadPath + "/customersReport-" + LocalDateTime.now().format(formatter) + ".xlsx";
        customerService.write(fileName);
        return "redirect:/admin?page=cars";
    }

    @GetMapping("/createBuysReport")
    public String createBuysReport() throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-hh-mm-ss");
        File uploadPath = new File("reports");
        if(!uploadPath.exists()) {
            uploadPath.mkdir();
        }
        String fileName = uploadPath + "/buysReport-" + LocalDateTime.now().format(formatter) + ".xlsx";
        buyCarService.write(fileName);
        return "redirect:/admin?page=cars";
    }

    @GetMapping("/createTestsReport")
    public String createTestsReport() throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-hh-mm-ss");
        File uploadPath = new File("reports");
        if(!uploadPath.exists()) {
            uploadPath.mkdir();
        }
        String fileName = uploadPath + "/testsReport-" + LocalDateTime.now().format(formatter) + ".xlsx";
        testCarService.write(fileName);
        return "redirect:/admin?page=cars";
    }
}

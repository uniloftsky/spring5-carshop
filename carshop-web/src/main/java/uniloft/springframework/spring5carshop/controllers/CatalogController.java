package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.spring5carshop.services.CarBrandService;
import uniloft.springframework.spring5carshop.services.CarService;
import uniloft.springframework.spring5carshop.services.CarTypeService;

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
    public String getCatalogPage() {
        return "catalog/index";
    }
}

package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import uniloft.springframework.spring5carshop.services.CarService;
import uniloft.springframework.spring5carshop.services.ImageService;

@Controller
public class ImageController {

    private final ImageService imageService;
    private final CarService carService;

    public ImageController(ImageService imageService, CarService carService) {
        this.imageService = imageService;
        this.carService = carService;
    }

}

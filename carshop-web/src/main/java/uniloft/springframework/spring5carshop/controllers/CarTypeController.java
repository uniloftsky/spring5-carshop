package uniloft.springframework.spring5carshop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.spring5carshop.model.CarType;
import uniloft.springframework.spring5carshop.services.CarTypeService;

@AllArgsConstructor
@Controller
public class CarTypeController {

    private final CarTypeService carTypeService;

    @RequestMapping("cartypes")
    public String getCarTypes(Model model) {
        model.addAttribute("cartypes", carTypeService.getCarTypes());
        return "cartype/show";
    }

    @RequestMapping("cartypes/new")
    public String newCarType(Model model) {
        model.addAttribute("cartype", new CarType());
        return "cartype/cartypeform";
    }

    @RequestMapping("cartypes/{id}/update")
    public String updateCarType(@PathVariable String id, Model model) {
        model.addAttribute("cartype", carTypeService.findById(Long.valueOf(id)));
        return "cartype/cartypeform";
    }

    @RequestMapping("cartypes/{id}/delete")
    public String deleteCarType(@PathVariable String id, Model model) {
        carTypeService.delete(carTypeService.findById(Long.valueOf(id)));
        return "redirect:/cartypes";
    }

    @PostMapping
    @RequestMapping("cartypeNew")
    public String saveOrUpdate(@ModelAttribute CarType carType) {
        carTypeService.saveOrUpdate(carType);
        return "redirect:cartypes";
    }
}

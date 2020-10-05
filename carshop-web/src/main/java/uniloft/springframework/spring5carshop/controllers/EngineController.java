package uniloft.springframework.spring5carshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.spring5carshop.model.Engine;
import uniloft.springframework.spring5carshop.services.EngineService;

@Controller
public class EngineController {

    private final EngineService engineService;

    public EngineController(EngineService engineService) {
        this.engineService = engineService;
    }

    @RequestMapping("engines")
    public String listEngines(Model model) {
        model.addAttribute("engines", engineService.getEngines());
        return "engine/list";
    }

    @RequestMapping("engines/{id}/show")
    public String showEngine(@PathVariable String id, Model model) {
        model.addAttribute("engine", engineService.findById(Long.valueOf(id)));
        return "engine/show";
    }

    @RequestMapping("engines/new")
    public String newEngine(Model model) {
        model.addAttribute("engine", new Engine());
        return "engine/engineform";
    }

    @RequestMapping("engines/{id}/update")
    public String updateEngine(@PathVariable String id, Model model) {
        model.addAttribute("engine", engineService.findById(Long.valueOf(id)));
        return "engine/engineform";
    }

    @RequestMapping("engines/{id}/delete")
    public String deleteEngine(@PathVariable String id) {
        engineService.delete(engineService.findById(Long.valueOf(id)));
        return "redirect:/engines";
    }

    @PostMapping
    @RequestMapping("newEngine")
    public String saveOrUpdate(@ModelAttribute Engine engine) {
        Engine savedEngine = engineService.save(engine);
        return "redirect:/engines/" + savedEngine.getId() + "/show";
    }


}

package uniloft.springframework.spring5carshop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniloft.springframework.spring5carshop.model.Customer;
import uniloft.springframework.spring5carshop.services.CustomerService;

@AllArgsConstructor
@Controller
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    @RequestMapping("customers")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        return "customer/list";
    }

    @GetMapping
    @RequestMapping("customers/{id}/show")
    public String showCustomer(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.findById(Long.valueOf(id)));
        return "customer/show";
    }

    @GetMapping
    @RequestMapping("customers/new")
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customerform";
    }

    @GetMapping
    @RequestMapping("customers/{id}/update")
        public String updateCustomer(@PathVariable String id, Model model) {
            model.addAttribute("customer", customerService.findById(Long.valueOf(id)));
            return "customer/customerform";
        }

    @PostMapping
    @RequestMapping("newCustomer")
    public String saveOrUpdate(@ModelAttribute Customer customer) {
        customerService.saveOrUpdate(customer);
        return "redirect:customers";
    }

    @GetMapping
    @RequestMapping("customers/{id}/delete")
    public String delete(@PathVariable String id, Model model) {
        customerService.delete(customerService.findById(Long.valueOf(id)));
        return "redirect:/customers";
    }

}

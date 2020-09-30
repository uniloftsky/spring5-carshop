package uniloft.springframework.spring5carshop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.spring5carshop.model.Customer;
import uniloft.springframework.spring5carshop.services.CustomerService;

@AllArgsConstructor
@Controller
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping("customers")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        return "customer/list";
    }

    @RequestMapping("customers/show/{id}")
    public String showCustomer(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.findById(Long.valueOf(id)));
        return "customer/show";
    }

    @RequestMapping("customers/new")
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customerform";
    }

    @RequestMapping("newCustomer")
    public String saveOrUpdate(@ModelAttribute Customer customer) {
        customerService.saveOrUpdate(customer);
        return "redirect:customers";
    }

}

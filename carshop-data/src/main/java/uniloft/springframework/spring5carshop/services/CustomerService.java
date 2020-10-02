package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.Customer;

import java.util.Set;

public interface CustomerService {

    Set<Customer> getCustomers();
    Customer findById(Long id);
    Customer saveOrUpdate(Customer customer);
    void delete(Customer customer);

}

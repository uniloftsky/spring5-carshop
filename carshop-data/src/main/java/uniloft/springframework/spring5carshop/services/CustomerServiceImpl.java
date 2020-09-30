package uniloft.springframework.spring5carshop.services;

import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.model.Customer;
import uniloft.springframework.spring5carshop.services.repositories.CustomerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Set<Customer> getCustomers() {
        Set<Customer> customers = new HashSet<>();
        customerRepository.findAll().iterator().forEachRemaining(customers::add);
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isEmpty()) {
            throw new RuntimeException("Expected customer not found!");
        }
        return customerOptional.get();
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        return customerRepository.save(customer);
    }
}

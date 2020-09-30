package uniloft.springframework.spring5carshop.services.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.spring5carshop.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}

package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.BuyCar;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.Customer;

import java.util.Set;

public interface BuyCarService {

    Set<BuyCar> getBuyCars();
    BuyCar save(BuyCar buyCar, Customer customer, Car car);
    BuyCar findById(Long id);
    void delete(BuyCar buyCar);

}

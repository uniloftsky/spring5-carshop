package uniloft.springframework.spring5carshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uniloft.springframework.spring5carshop.model.Car;

import java.util.Set;
import java.util.TreeSet;

public interface CarService {

    Set<Car> getCars();
    TreeSet<Car> getSortedCars();
    Car findById(Long id);
    Long getCarsCount();
    Page<Car> findAll(Pageable pageable);

}

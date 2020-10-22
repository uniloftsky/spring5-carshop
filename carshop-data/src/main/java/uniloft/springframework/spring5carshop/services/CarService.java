package uniloft.springframework.spring5carshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uniloft.springframework.spring5carshop.model.Car;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public interface CarService {

    Set<Car> getCars();
    TreeSet<Car> getSortedCars(Comparator<Car> comparator);
    Car findById(Long id);
    Long getCarsCount();
    Page<Car> findAll(Pageable pageable);
    BigDecimal findMinPrice();
    BigDecimal findMaxPrice();

}

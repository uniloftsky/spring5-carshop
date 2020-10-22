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
    Set<Car> findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(String brandName, String modelName, String bodyName);
    Set<Car> findCarsByModel_ModelNameAndBody_BodyName(String modelName, String bodyName);
    Set<Car> findCarsByBrand_BrandName(String brandName);
    Set<Car> findCarsByBrand_BrandNameAndModel_ModelName(String brandName, String modelName);
/*    Set<Car> findCarsByBrand_BrandName(String brandName);
    Set<Car> findCarsByModel_ModelName(String modelName);
    Set<Car> findCarsByBody_BodyName(String bodyName);
    Set<Car> findCarsByBrand_BrandNameAndModel_ModelName(String brandName, String modelName);
    Set<Car> findCarsByBrand_BrandNameAndBody_BodyName(String brandName, String bodyName);
    Set<Car> findCarsByModel_ModelNameAndBody_BodyName(String modelName, String bodyName);*/

}

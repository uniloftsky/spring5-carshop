package uniloft.springframework.spring5carshop.services;

import uniloft.springframework.spring5carshop.model.Car;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface CarService {

    Set<Car> getCars();
    TreeSet<Car> getSortedCars(Comparator<Car> comparator);
    Car findById(Long id);
    Long getCarsCount();
    Set<Car> findAll();
    Set<Car> findCars(BigDecimal minPrice, BigDecimal maxPrice);
    BigDecimal findMinPrice();
    BigDecimal findMaxPrice();
    Set<Car> findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(List<String> brandName, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByModel_ModelNameAndBody_BodyName(List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByBrand_BrandName(List<String> brandName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByBrand_BrandNameAndModel_ModelName(List<String> brandName, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByModel_ModelName(List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByBody_BodyName(List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);
    Set<Car> findCarsByBrand_BrandNameAndBody_BodyName(List<String> brandName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice);

}

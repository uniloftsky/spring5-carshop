package uniloft.springframework.spring5carshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    Page<Car> findAll(Pageable pageable);
    Page<Car> findCars(BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
    BigDecimal findMinPrice();
    BigDecimal findMaxPrice();
    Page<Car> findCarsByBrand_BrandNameAndModel_ModelNameAndBody_BodyName(List<String> brandName, List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
    Page<Car> findCarsByModel_ModelNameAndBody_BodyName(List<String> modelName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
    Page<Car> findCarsByBrand_BrandName(List<String> brandName, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
    Page<Car> findCarsByBrand_BrandNameAndModel_ModelName(List<String> brandName, List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
    Page<Car> findCarsByModel_ModelName(List<String> modelName, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
    Page<Car> findCarsByBody_BodyName(List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);
    Page<Car> findCarsByBrand_BrandNameAndBody_BodyName(List<String> brandName, List<String> bodyName, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable);

}

package uniloft.springframework.spring5carshop.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.comparators.CarBodyAscendingComparatorByName;
import uniloft.springframework.spring5carshop.comparators.CarBrandAscendingComparatorByName;
import uniloft.springframework.spring5carshop.comparators.CarModelAscendingComparatorByName;
import uniloft.springframework.spring5carshop.model.CarBody;
import uniloft.springframework.spring5carshop.model.CarBrand;
import uniloft.springframework.spring5carshop.model.CarModel;
import uniloft.springframework.spring5carshop.services.repositories.CarBrandRepository;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
@Service
public class CarBrandServiceImpl implements CarBrandService {

    private final CarBrandRepository carBrandRepository;

    public CarBrandServiceImpl(CarBrandRepository carBrandRepository) {
        this.carBrandRepository = carBrandRepository;
    }

    @Override
    public Set<CarBrand> getCarBrands() {
        Comparator<CarBrand> comparator = new CarBrandAscendingComparatorByName();
        TreeSet<CarBrand> cars = new TreeSet<>(comparator);
        carBrandRepository.findAll().iterator().forEachRemaining(cars::add);
        return cars;
    }

    @Override
    public Set<CarModel> getBrandModels() {
        Comparator<CarModel> comparator = new CarModelAscendingComparatorByName();
        Set<CarBrand> carBrands = new HashSet<>();
        TreeSet<CarModel> cars = new TreeSet<>(comparator);
        carBrandRepository.findAll().iterator().forEachRemaining(carBrands::add);
        carBrands.iterator().forEachRemaining(carBrand -> carBrand.getCarModelSet().iterator().forEachRemaining(cars::add));
        return cars;
    }

    public Set<CarBody> getModelBodies() {
        Comparator<CarBody> comparator = new CarBodyAscendingComparatorByName();
        Set<CarBrand> carBrands = new HashSet<>();
        TreeSet<CarBody> cars = new TreeSet<>(comparator);
        carBrandRepository.findAll().iterator().forEachRemaining(carBrands::add);
        carBrands.iterator().forEachRemaining(carBrand -> carBrand.getCarModelSet()
                .iterator()
                .forEachRemaining(carModel -> carModel.getCarBodySet()
                        .iterator()
                        .forEachRemaining(cars::add)));
        return cars;
    }

    @Override
    public CarBrand saveBrand(CarBrand carBrand) {
        return carBrandRepository.save(carBrand);
    }
}

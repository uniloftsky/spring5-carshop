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
import uniloft.springframework.spring5carshop.services.repositories.CarModelRepository;

import java.util.*;

@Slf4j
@Service
public class CarBrandServiceImpl implements CarBrandService {

    private final CarBrandRepository carBrandRepository;
    private final CarModelRepository carModelRepository;

    public CarBrandServiceImpl(CarBrandRepository carBrandRepository, CarModelRepository carModelRepository) {
        this.carBrandRepository = carBrandRepository;
        this.carModelRepository = carModelRepository;
    }

    @Override
    public CarBrand findCarBrandById(Long id) {
        Optional<CarBrand> brandOptional = carBrandRepository.findById(id);
        if (brandOptional.isEmpty()) {
            throw new RuntimeException("Expected car brand not found!");
        }
        return brandOptional.get();
    }

    @Override
    public CarModel findCarModelById(Long id) {
        return getBrandModels().stream().filter(carModel -> carModel.getId().equals(id)).findFirst().get();
    }

    @Override
    public void deleteBrand(CarBrand carBrand) {
        carBrandRepository.delete(carBrand);
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

    @Override
    public CarModel saveModel(CarModel carModel) {
        return carModelRepository.save(carModel);
    }
}

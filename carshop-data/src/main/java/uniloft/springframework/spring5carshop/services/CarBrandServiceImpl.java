package uniloft.springframework.spring5carshop.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.model.CarBody;
import uniloft.springframework.spring5carshop.model.CarBrand;
import uniloft.springframework.spring5carshop.model.CarModel;
import uniloft.springframework.spring5carshop.services.repositories.CarBrandRepository;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class CarBrandServiceImpl implements CarBrandService {

    private final CarBrandRepository carBrandRepository;

    public CarBrandServiceImpl(CarBrandRepository carBrandRepository) {
        this.carBrandRepository = carBrandRepository;
    }

    @Override
    public Set<CarBrand> getBrands() {
        Set<CarBrand> carBrands = new HashSet<>();
        carBrandRepository.findAll().iterator().forEachRemaining(carBrands::add);
        return carBrands;
    }

    @Override
    public Set<CarModel> getBrandModels() {
        Set<CarModel> carModels = new HashSet<>();
        Set<CarBrand> carBrands = new HashSet<>();
        carBrandRepository.findAll().iterator().forEachRemaining(carBrands::add);
        carBrands.iterator().forEachRemaining(carBrand -> carBrand.getCarModelSet().iterator().forEachRemaining(carModels::add));
        return carModels;
    }

    public Set<CarBody> getModelBodies() {
        Set<CarBrand> carBrands = new HashSet<>();
        Set<CarBody> carBodies = new HashSet<>();
        carBrandRepository.findAll().iterator().forEachRemaining(carBrands::add);
        carBrands.iterator().forEachRemaining(carBrand -> carBrand.getCarModelSet()
                .iterator()
                .forEachRemaining(carModel -> carModel.getCarBodySet()
                        .iterator()
                        .forEachRemaining(carBodies::add)));
        return carBodies;
    }
}

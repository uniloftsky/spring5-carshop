package uniloft.springframework.spring5carshop.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.model.CarType;
import uniloft.springframework.spring5carshop.services.repositories.CarTypeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class CarTypeServiceImpl implements CarTypeService {

    private final CarTypeRepository carTypeRepository;

    @Override
    public Set<CarType> getCarTypes() {
        Set<CarType> types = new HashSet<>();
        carTypeRepository.findAll().iterator().forEachRemaining(types::add);
        return types;
    }

    @Override
    public CarType saveOrUpdate(CarType carType) {
        return carTypeRepository.save(carType);
    }

    @Override
    public CarType findById(Long id) {
        Optional<CarType> carTypeOptional = carTypeRepository.findById(id);
        if(carTypeOptional.isEmpty()) {
            throw new RuntimeException("Expected cartype not found!");
        }
        return carTypeOptional.get();
    }
}

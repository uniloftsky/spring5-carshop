package uniloft.springframework.spring5carshop.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.comparators.CarTypeAscendingComparatorByName;
import uniloft.springframework.spring5carshop.exceptions.NotFoundException;
import uniloft.springframework.spring5carshop.model.CarType;
import uniloft.springframework.spring5carshop.services.repositories.CarTypeRepository;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@AllArgsConstructor
@Service
public class CarTypeServiceImpl implements CarTypeService {

    private final CarTypeRepository carTypeRepository;

    @Override
    public Set<CarType> getCarTypes() {
        Comparator<CarType> comparator = new CarTypeAscendingComparatorByName();
        TreeSet<CarType> types = new TreeSet<>(comparator);
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
            throw new NotFoundException("Тип кузова з ID: " + id + " не знайдено!");
        }
        return carTypeOptional.get();
    }

    @Override
    public void delete(CarType carType) {
        carTypeRepository.delete(carType);
    }
}

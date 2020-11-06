package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.Car;

import java.util.Comparator;

public class CarAscendingComparatorById implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

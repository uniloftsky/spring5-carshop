package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.CarType;

import java.util.Comparator;

public class CarTypeAscendingComparatorById implements Comparator<CarType> {

    @Override
    public int compare(CarType o1, CarType o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

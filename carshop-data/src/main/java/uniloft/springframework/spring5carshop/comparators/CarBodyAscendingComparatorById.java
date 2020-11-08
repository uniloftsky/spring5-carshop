package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.CarBody;

import java.util.Comparator;

public class CarBodyAscendingComparatorById implements Comparator<CarBody> {

    @Override
    public int compare(CarBody o1, CarBody o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.CarBody;

import java.util.Comparator;

public class CarBodyAscendingComparatorByName implements Comparator<CarBody> {

    @Override
    public int compare(CarBody o1, CarBody o2) {
        return o1.getBodyName().compareTo(o2.getBodyName());
    }
}

package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.Car;

import java.util.Comparator;

public class CarAscendingComparatorByPrice implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return (o1.getPrice().compareTo(o2.getPrice()));
    }

}

package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.Car;

import java.util.Comparator;

public class CarDescendingComparatorById implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return (int)(o2.getId() - o1.getId());
    }

}

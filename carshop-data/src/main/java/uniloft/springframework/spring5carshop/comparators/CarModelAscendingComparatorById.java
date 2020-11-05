package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.CarModel;

import java.util.Comparator;

public class CarModelAscendingComparatorById implements Comparator<CarModel> {

    @Override
    public int compare(CarModel o1, CarModel o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

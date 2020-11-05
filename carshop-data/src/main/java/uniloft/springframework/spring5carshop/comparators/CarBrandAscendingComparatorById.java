package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.CarBrand;

import java.util.Comparator;

public class CarBrandAscendingComparatorById implements Comparator<CarBrand> {

    @Override
    public int compare(CarBrand o1, CarBrand o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

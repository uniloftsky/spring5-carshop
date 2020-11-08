package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.TestCar;

import java.util.Comparator;

public class TestCarAscendingComparatorById implements Comparator<TestCar> {

    @Override
    public int compare(TestCar o1, TestCar o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

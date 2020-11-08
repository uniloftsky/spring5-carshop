package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.BuyCar;

import java.util.Comparator;

public class BuyCarAscendingComparatorById implements Comparator<BuyCar> {

    @Override
    public int compare(BuyCar o1, BuyCar o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

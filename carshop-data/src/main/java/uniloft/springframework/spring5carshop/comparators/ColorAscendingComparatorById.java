package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.Color;

import java.util.Comparator;

public class ColorAscendingComparatorById implements Comparator<Color> {

    @Override
    public int compare(Color o1, Color o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

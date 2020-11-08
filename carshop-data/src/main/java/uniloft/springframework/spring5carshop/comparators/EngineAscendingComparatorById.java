package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.Engine;

import java.util.Comparator;

public class EngineAscendingComparatorById implements Comparator<Engine> {

    @Override
    public int compare(Engine o1, Engine o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

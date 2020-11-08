package uniloft.springframework.spring5carshop.comparators;

import uniloft.springframework.spring5carshop.model.Customer;

import java.util.Comparator;

public class CustomerAscendingComparatorById implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getId().compareTo(o2.getId());
    }
}

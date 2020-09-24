package uniloft.springframework.spring5carshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class TestCar extends BaseEntity {

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    private LocalDate date;
    private int count;
    private BigDecimal price;
}

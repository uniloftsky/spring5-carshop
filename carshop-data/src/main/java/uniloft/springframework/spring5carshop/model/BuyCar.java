package uniloft.springframework.spring5carshop.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class BuyCar extends BaseEntity {

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private int count;
    @NotBlank
    private BigDecimal price;
}

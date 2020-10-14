package uniloft.springframework.spring5carshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class CarBody extends BaseEntity {

    private String bodyName;

    @ManyToOne
    private CarModel model;

}

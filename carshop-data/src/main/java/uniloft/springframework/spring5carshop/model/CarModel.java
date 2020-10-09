package uniloft.springframework.spring5carshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class CarModel extends BaseEntity {

    private String modelName;

    @ManyToOne
    private CarBrand brand;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private Set<CarBody> carBodySet = new HashSet<>();

}

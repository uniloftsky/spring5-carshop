package uniloft.springframework.spring5carshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class CarBrand extends BaseEntity {

    private String brandName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private Set<CarModel> carModelSet = new HashSet<>();

}

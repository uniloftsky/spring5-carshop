package uniloft.springframework.spring5carshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;
    private String address;
    private String telephone;

    @OneToMany(mappedBy = "customer")
    private Set<BuyCar> buyCars = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<TestCar> testCars = new HashSet<>();
}

package uniloft.springframework.spring5carshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Car extends BaseEntity {

    @ManyToOne
    private Engine engine;

    @ManyToOne
    private CarType carType;

    @OneToMany(mappedBy = "car")
    private Set<BuyCar> buyCars = new HashSet<>();

    @OneToMany(mappedBy = "car")
    private Set<TestCar> testCars = new HashSet<>();

    private String brandName;
    private String modelName;
    private String bodyName;
    private String color;

    @Lob
    private Byte[] image;
}

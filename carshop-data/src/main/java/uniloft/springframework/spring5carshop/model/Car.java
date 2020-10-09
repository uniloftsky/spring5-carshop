package uniloft.springframework.spring5carshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
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

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private CarBrand brand;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private CarModel model;

    @ManyToOne
    @JoinColumn(name = "body_id")
    private CarBody body;
    private BigDecimal price;

    @ManyToOne
    private Color color;

    @Lob
    private String image;
}

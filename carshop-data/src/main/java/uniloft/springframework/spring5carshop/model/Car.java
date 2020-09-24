package uniloft.springframework.spring5carshop.model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

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

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBodyName() {
        return bodyName;
    }

    public void setBodyName(String bodyName) {
        this.bodyName = bodyName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}

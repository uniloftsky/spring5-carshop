package uniloft.springframework.spring5carshop.model;

import uniloft.springframework.spring5carshop.model.enums.EngineConfig;
import uniloft.springframework.spring5carshop.model.enums.EngineType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Engine extends BaseEntity {

    private String name;

    @Enumerated(value = EnumType.STRING)
    private EngineType type;

    private int capacity;
    private int power;

    @Enumerated(value = EnumType.STRING)
    private EngineConfig config;

    private int cylinders;

    public Engine() {
    }

    public Engine(String name, EngineType type, int capacity, int power, EngineConfig config, int cylinders) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.power = power;
        this.config = config;
        this.cylinders = cylinders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EngineType getType() {
        return type;
    }

    public void setType(EngineType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public EngineConfig getConfig() {
        return config;
    }

    public void setConfig(EngineConfig config) {
        this.config = config;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }
}

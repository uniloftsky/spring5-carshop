package uniloft.springframework.spring5carshop.model.enums;

public enum EngineType {
    PETROL("Бензин"),
    DIESEL("Дизель");

    private final String description;

    EngineType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

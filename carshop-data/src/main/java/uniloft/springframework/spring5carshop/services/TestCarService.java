package uniloft.springframework.spring5carshop.services;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.Customer;
import uniloft.springframework.spring5carshop.model.TestCar;

import java.io.IOException;
import java.util.Set;

public interface TestCarService {

    Set<TestCar> getTestCars();
    TestCar save(TestCar buyCar, Customer customer, Car car);
    TestCar findById(Long id);
    void delete(TestCar buyCar);
    void write(String fileName) throws IOException;
    Sheet createSheet(XSSFWorkbook workbook);
    void createHeader(XSSFWorkbook workbook, Sheet sheet);
    void createCells(XSSFWorkbook workbook, Sheet sheet);

}

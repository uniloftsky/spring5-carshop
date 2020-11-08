package uniloft.springframework.spring5carshop.services;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import uniloft.springframework.spring5carshop.model.BuyCar;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.Customer;

import java.io.IOException;
import java.util.Set;

public interface BuyCarService {

    Set<BuyCar> getBuyCars();
    BuyCar save(BuyCar buyCar, Customer customer, Car car);
    BuyCar findById(Long id);
    void delete(BuyCar buyCar);
    void write(String fileName) throws IOException;
    Sheet createSheet(XSSFWorkbook workbook);
    void createHeader(XSSFWorkbook workbook, Sheet sheet);
    void createCells(XSSFWorkbook workbook, Sheet sheet);

}

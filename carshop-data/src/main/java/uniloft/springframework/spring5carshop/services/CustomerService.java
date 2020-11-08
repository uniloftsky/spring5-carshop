package uniloft.springframework.spring5carshop.services;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import uniloft.springframework.spring5carshop.model.Customer;

import java.io.IOException;
import java.util.Set;

public interface CustomerService {

    Set<Customer> getCustomers();
    Customer findById(Long id);
    Customer saveOrUpdate(Customer customer);
    void delete(Customer customer);
    void write(String fileName) throws IOException;
    Sheet createSheet(XSSFWorkbook workbook);
    void createHeader(XSSFWorkbook workbook, Sheet sheet);
    void createCells(XSSFWorkbook workbook, Sheet sheet);

}

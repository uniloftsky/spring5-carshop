package uniloft.springframework.spring5carshop.services;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.exceptions.NotFoundException;
import uniloft.springframework.spring5carshop.model.Customer;
import uniloft.springframework.spring5carshop.services.repositories.CustomerRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Set<Customer> getCustomers() {
        Set<Customer> customers = new HashSet<>();
        customerRepository.findAll().iterator().forEachRemaining(customers::add);
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isEmpty()) {
            throw new NotFoundException("Клієнта з ID: " + id + " не знайдено!");
        }
        return customerOptional.get();
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void write(String fileName) throws IOException {
        var workbook = new XSSFWorkbook();
        var sheet = createSheet(workbook);
        createHeader(workbook, sheet);
        createCells(workbook, sheet);
        try(var outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
        }
        workbook.close();
    }

    @Override
    public Sheet createSheet(XSSFWorkbook workbook) {
        var sheet = workbook.createSheet("Клиенты");
        sheet.setColumnWidth(0, 4000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 4000);
        return sheet;
    }

    @Override
    public void createHeader(XSSFWorkbook workbook, Sheet sheet) {
        var header = sheet.createRow(0);

        var headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        var font = workbook.createFont();
        font.setFontName("Times New Roman");
        headerStyle.setFont(font);

        var headerCell = header.createCell(0);
        headerCell.setCellValue("Ім'я");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Прізвище");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("Номер телефону");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("Адреса");
        headerCell.setCellStyle(headerStyle);
    }

    @Override
    public void createCells(XSSFWorkbook workbook, Sheet sheet) {
        var style = workbook.createCellStyle();
        style.setWrapText(true);
        sheet.setDefaultColumnStyle(1, style);

        int i = 0;

        for(Customer customer : customerRepository.findAll()) {

            var row = sheet.createRow(i + 1);

            var cell = row.createCell(0);
            cell.setCellValue(customer.getFirstName());

            cell = row.createCell(1);
            cell.setCellValue(customer.getLastName());

            cell = row.createCell(2);
            cell.setCellValue(customer.getTelephone());

            cell = row.createCell(3);
            cell.setCellValue(customer.getAddress());

            i++;
        }

    }
}

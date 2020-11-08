package uniloft.springframework.spring5carshop.services;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.Customer;
import uniloft.springframework.spring5carshop.model.TestCar;
import uniloft.springframework.spring5carshop.services.repositories.TestCarRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TestCarServiceImpl implements TestCarService {

    private final TestCarRepository testCarRepository;

    public TestCarServiceImpl(TestCarRepository testCarRepository) {
        this.testCarRepository = testCarRepository;
    }

    @Override
    public Set<TestCar> getTestCars() {
        Set<TestCar> testCars = new HashSet<>();
        testCarRepository.findAll().iterator().forEachRemaining(testCars::add);
        return testCars;
    }

    @Override
    public TestCar save(TestCar testCar, Customer customer, Car car) {
        testCar.setCustomer(customer);
        testCar.setCar(car);
        testCar.setDate(LocalDate.now());
        testCar.setCount(1);
        testCar.setPrice(car.getTestPrice());
        return testCarRepository.save(testCar);
    }

    @Override
    public TestCar findById(Long id) {
        Optional<TestCar> buyCarOptional = testCarRepository.findById(id);
        if(buyCarOptional.isEmpty()) {
            throw new RuntimeException("Expected buycar not found!");
        }
        return buyCarOptional.get();
    }

    @Override
    public void delete(TestCar testCar) {
        testCarRepository.delete(testCar);
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
        headerCell.setCellValue("Клієнт");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Авто");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("Дата");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("Ціна");
        headerCell.setCellStyle(headerStyle);
    }

    @Override
    public void createCells(XSSFWorkbook workbook, Sheet sheet) {
        var style = workbook.createCellStyle();
        style.setWrapText(true);
        sheet.setDefaultColumnStyle(1, style);

        var createHelper = workbook.getCreationHelper();
        style.setDataFormat(createHelper.createDataFormat().getFormat("dd.mm.yyyy"));

        int i = 0;

        for(TestCar testCar: testCarRepository.findAll()) {

            var row = sheet.createRow(i + 1);

            var cell = row.createCell(0);
            cell.setCellValue(testCar.getCustomer().getFirstName() + " " + testCar.getCustomer().getLastName());

            cell = row.createCell(1);
            cell.setCellValue(testCar.getCar().getBrand().getBrandName() + " " + testCar.getCar().getModel().getModelName() + " " + testCar.getCar().getBody().getBodyName());

            cell = row.createCell(2);
            cell.setCellValue(testCar.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

            cell = row.createCell(3);
            cell.setCellValue(testCar.getPrice().toPlainString());

            i++;
        }

    }
}

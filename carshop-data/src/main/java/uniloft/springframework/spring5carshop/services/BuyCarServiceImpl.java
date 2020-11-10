package uniloft.springframework.spring5carshop.services;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import uniloft.springframework.spring5carshop.exceptions.NotFoundException;
import uniloft.springframework.spring5carshop.model.BuyCar;
import uniloft.springframework.spring5carshop.model.Car;
import uniloft.springframework.spring5carshop.model.Customer;
import uniloft.springframework.spring5carshop.services.repositories.BuyCarRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BuyCarServiceImpl implements BuyCarService {

    private final BuyCarRepository buyCarRepository;

    public BuyCarServiceImpl(BuyCarRepository buyCarRepository) {
        this.buyCarRepository = buyCarRepository;
    }

    @Override
    public Set<BuyCar> getBuyCars() {
        Set<BuyCar> buyCars = new HashSet<>();
        buyCarRepository.findAll().iterator().forEachRemaining(buyCars::add);
        return buyCars;
    }

    @Override
    public BuyCar save(BuyCar buyCar, Customer customer, Car car) {
        buyCar.setCustomer(customer);
        buyCar.setCar(car);
        buyCar.setDate(LocalDate.now());
        buyCar.setCount(1);
        buyCar.setPrice(car.getPrice());
        return buyCarRepository.save(buyCar);
    }

    @Override
    public BuyCar findById(Long id) {
        Optional<BuyCar> buyCarOptional = buyCarRepository.findById(id);
        if(buyCarOptional.isEmpty()) {
            throw new NotFoundException("Покупку з ID: " + id + " не знайдено!");
        }
        return buyCarOptional.get();
    }

    @Override
    public void delete(BuyCar buyCar) {
        buyCarRepository.delete(buyCar);
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

        for(BuyCar buyCar: buyCarRepository.findAll()) {

            var row = sheet.createRow(i + 1);

            var cell = row.createCell(0);
            cell.setCellValue(buyCar.getCustomer().getFirstName() + " " + buyCar.getCustomer().getLastName());

            cell = row.createCell(1);
            cell.setCellValue(buyCar.getCar().getBrand().getBrandName() + " " + buyCar.getCar().getModel().getModelName() + " " + buyCar.getCar().getBody().getBodyName());

            cell = row.createCell(2);
            cell.setCellValue(buyCar.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

            cell = row.createCell(3);
            cell.setCellValue(buyCar.getPrice().toPlainString());

            i++;
        }

    }
}

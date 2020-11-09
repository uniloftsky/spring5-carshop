package uniloft.springframework.spring5carshop.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import uniloft.springframework.spring5carshop.model.Car;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    private String uploadPath = System.getProperty("user.dir") + "/resources/";

    private final CarService carService;

    public ImageServiceImpl(CarService carService) {
        this.carService = carService;
    }

    @Override
    @Transactional
    public void saveImageFile(Car car, MultipartFile file) throws IOException {

        if(file != null) {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();

            String resultFilename = "cars/" + uuidFile + "-" + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + resultFilename));

            car.setImage(resultFilename);
        }
        carService.save(car);
    }
}

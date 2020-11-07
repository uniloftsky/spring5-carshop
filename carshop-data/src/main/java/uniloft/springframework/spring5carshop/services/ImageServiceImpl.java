package uniloft.springframework.spring5carshop.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import uniloft.springframework.spring5carshop.model.Car;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    private final CarService carService;

    public ImageServiceImpl(CarService carService) {
        this.carService = carService;
    }

    @Override
    @Transactional
    public void saveImageFile(Car car, MultipartFile file) throws IOException {

        String originalFileName = file.getOriginalFilename();
        String fileName = originalFileName.substring(0, originalFileName.indexOf("."));
        String typeName = originalFileName.substring(originalFileName.indexOf("."), originalFileName.length());
        String resultName;

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String uuid = UUID.randomUUID().toString();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("carshop-web/target/classes/static/resources/images/cars/"+uuid+"-"+fileName+typeName)));
                resultName = "resources/images/cars/" + uuid+"-"+fileName+typeName;
                car.setImage(resultName);
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                System.out.println("Error upload");
            }
        }
        carService.save(car);
    }
}

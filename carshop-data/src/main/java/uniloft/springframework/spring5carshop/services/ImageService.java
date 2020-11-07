package uniloft.springframework.spring5carshop.services;

import org.springframework.web.multipart.MultipartFile;
import uniloft.springframework.spring5carshop.model.Car;

import java.io.IOException;

public interface ImageService {

    void saveImageFile(Car car, MultipartFile file) throws IOException;

}

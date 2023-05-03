package pl.dogout.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.dogout.app.model.Image;
import pl.dogout.app.repository.ImageRepository;
import pl.dogout.app.util.ImageUtil;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtil.compressImage(file.getBytes())).build());

        return "File " + file.getOriginalFilename() + " uploaded successfully!";
    }

    public Image downloadImage(String fileName) {
        Optional<Image> image = imageRepository.findByName(fileName);
        return image.orElse(null);
    }

}

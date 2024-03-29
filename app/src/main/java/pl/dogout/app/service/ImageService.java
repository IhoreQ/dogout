package pl.dogout.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.dogout.app.model.Image;
import pl.dogout.app.repository.ImageRepository;
import pl.dogout.app.util.ImageUtil;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageService {

    ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String uploadImage(MultipartFile file) throws IOException {

        int nameLength = 10;
        String filename = UUID.randomUUID()
                .toString()
                .substring(0, nameLength);

        imageRepository.save(Image.builder()
                .name(filename)
                .type(file.getContentType())
                .image(ImageUtil.compressImage(file.getBytes())).build());

        return filename;
    }

    public Image downloadImage(String fileName) {
        Optional<Image> image = imageRepository.findByName(fileName);
        return image.orElse(null);
    }

    public void deleteImage(String imageName) {
        Optional<Image> foundImage = imageRepository.findByName(imageName);
        foundImage.ifPresent(image -> imageRepository.delete(image));
    }

}
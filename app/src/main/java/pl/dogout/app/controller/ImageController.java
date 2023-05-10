package pl.dogout.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.dogout.app.model.Image;
import pl.dogout.app.service.ImageService;
import pl.dogout.app.util.ImageUtil;

import java.io.IOException;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String response = imageService.uploadImage(file);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{name}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable("name") String name) throws IOException {
        Image image = imageService.downloadImage(name);

        return image == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.status(HttpStatus.OK)
                        .contentType(MediaType.valueOf(image.getType()))
                        .body(ImageUtil.decompressImage(image.getImage()));
    }
}

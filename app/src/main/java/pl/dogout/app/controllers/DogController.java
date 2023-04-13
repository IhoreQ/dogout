package pl.dogout.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.models.Dog;
import pl.dogout.app.services.DogService;

@RestController
@RequestMapping("/api/dog")
@CrossOrigin
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping
    public ResponseEntity<String> addDog() {
        return ResponseEntity.ok("New Dog");
    }

    @GetMapping
    public ResponseEntity<String> getDogInfo() {
        Dog dog = dogService.getDogInfo(26L);

        return ResponseEntity.ok(dog.getName());
    }

    @GetMapping("/{placeId}")
    public ResponseEntity<String> getAllDogs(@PathVariable String placeId) {
        return ResponseEntity.ok("All dogs");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDog() {
        return ResponseEntity.ok("Your Dog has been deleted");
    }

}

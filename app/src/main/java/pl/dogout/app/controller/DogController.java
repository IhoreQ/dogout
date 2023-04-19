package pl.dogout.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.dto.requests.DogAddRequest;
import pl.dogout.app.model.Dog;
import pl.dogout.app.service.DogService;

import java.util.List;

@RestController
@RequestMapping("/api/dog")
@CrossOrigin
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> addDog(@RequestBody DogAddRequest dogAddRequest) {
        // TODO
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> getDogInfo() {

        Dog dog = dogService.getDogInfo(26L);
        return ResponseEntity.ok(dog.getName());
    }

    @GetMapping("/{placeId}")
    public List<Dog> getAllDogsFromPlace(@PathVariable Long placeId) {
        return dogService.getDogsFromPlace(placeId);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteDog() {


        return ResponseEntity.ok("Your Dog has been deleted");
    }

}

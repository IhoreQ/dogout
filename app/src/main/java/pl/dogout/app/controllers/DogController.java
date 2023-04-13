package pl.dogout.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dog")
@CrossOrigin
public class DogController {

    @PostMapping("/add")
    public ResponseEntity<String> addDog() {
        return ResponseEntity.ok("New Dog");
    }

    @GetMapping("/info")
    public ResponseEntity<String> getDogInfo() {
        return ResponseEntity.ok("Your Dog info");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDog() {
        return ResponseEntity.ok("Your Dog has been deleted");
    }

}

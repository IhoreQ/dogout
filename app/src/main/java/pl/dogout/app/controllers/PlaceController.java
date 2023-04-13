package pl.dogout.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.repository.PlaceRepository;

@RestController
@RequestMapping("/api/place")
@CrossOrigin
public class PlaceController {

    private PlaceRepository placeRepository;

    @GetMapping("/all")
    public ResponseEntity<String> getALlPlaces() {
        return ResponseEntity.ok("All places");
    }

    @GetMapping("/:id")
    public ResponseEntity<String> getPlace() {
        return ResponseEntity.ok("Place");
    }

}

package pl.dogout.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.repository.PlaceRepository;

@RestController
@RequestMapping("/api/places")
@CrossOrigin
public class PlaceController {

    private PlaceRepository placeRepository;

    @GetMapping
    public ResponseEntity<String> getALlPlaces() {
        return ResponseEntity.ok("All places");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getPlace(@PathVariable String id) {
        return ResponseEntity.ok(id);
    }

}

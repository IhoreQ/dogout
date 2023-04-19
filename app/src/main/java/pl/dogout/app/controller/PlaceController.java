package pl.dogout.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.model.Place;
import pl.dogout.app.service.PlaceService;

import java.util.List;

@RestController
@RequestMapping("/api/places")
@CrossOrigin
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<Place> getALlPlaces() {
        return placeService.getAllPlaces();
    }
}

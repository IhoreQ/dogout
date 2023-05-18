package pl.dogout.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dogout.app.model.Place;
import pl.dogout.app.repository.CityRepository;
import pl.dogout.app.repository.PlaceRepository;

import java.util.List;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final CityRepository cityRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository, CityRepository cityRepository) {
        this.placeRepository = placeRepository;
        this.cityRepository = cityRepository;
    }

    public List<Place> getAllPlaces() {
        return placeRepository.findAllPlaces();
    }

    public Place getPlaceById(Long id) {
        return placeRepository.findById(id).orElse(null);
    }

}

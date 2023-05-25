package pl.dogout.app.service;

import org.springframework.stereotype.Service;
import pl.dogout.app.model.City;
import pl.dogout.app.repository.CityRepository;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}

package pl.dogout.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dogout.app.model.Dog;
import pl.dogout.app.repository.DogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    private final DogRepository dogRepository;

    @Autowired
    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog getDogInfo(Long id) {
        Optional<Dog> dog = dogRepository.findById(id);

        return dog.orElse(null);
    }

    public List<Dog> getDogsFromPlace(Long id) {
        return null;
    }

}

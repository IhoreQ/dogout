package pl.dogout.app.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dogout.app.models.Dog;
import pl.dogout.app.repository.DogRepository;

@Service
public class DogService {

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog getDogInfo(Long id) {
        return dogRepository.findById(id).get();
    }

}

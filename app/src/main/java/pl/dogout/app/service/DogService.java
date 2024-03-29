package pl.dogout.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dogout.app.controller.dto.request.DogAddRequest;
import pl.dogout.app.model.Dog;
import pl.dogout.app.model.DogBreed;
import pl.dogout.app.model.User;
import pl.dogout.app.repository.DogBreedRepository;
import pl.dogout.app.repository.DogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    private final UserService userService;
    private final ImageService imageService;
    private final DogRepository dogRepository;
    private final DogBreedRepository dogBreedRepository;

    public DogService(UserService userService, ImageService imageService, DogRepository dogRepository, DogBreedRepository dogBreedRepository) {
        this.userService = userService;
        this.imageService = imageService;
        this.dogRepository = dogRepository;
        this.dogBreedRepository = dogBreedRepository;
    }

    public Dog getDogInfo(User user) {
        Optional<Dog> dog = dogRepository.findByOwner(user);
        return dog.orElse(null);
    }

    public boolean deleteDog(User user) {

        if (!user.hasDog())
            return false;

        Optional<Dog> foundDog = dogRepository.findByOwner(user);

        if (foundDog.isPresent()) {
            Dog dog = foundDog.get();
            imageService.deleteImage(dog.getPhoto());
            userService.changeHasDogState(user);
            dogRepository.delete(dog);

            return true;
        } else {
            return false;
        }
    }

    public boolean addDog(User user, DogAddRequest dogAddRequest, String photo) {

        Optional<DogBreed> foundBreed = dogBreedRepository.findById(dogAddRequest.breedId());

        if (foundBreed.isPresent()) {
            DogBreed breed = foundBreed.get();
            Dog dog = new Dog(dogAddRequest.name(), dogAddRequest.age(), dogAddRequest.gender(), dogAddRequest.description(), breed, photo, user);

            dogRepository.save(dog);
            userService.changeHasDogState(user);

            return true;
        }

        return false;
    }

    public List<DogBreed> getAllBreeds() {
        return dogBreedRepository.findAllNamesWithIds();
    }

}

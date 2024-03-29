package pl.dogout.app.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import pl.dogout.app.model.DogBreed;

public record DogBreedResponse(Long id,
                               String name) {
    @JsonCreator
    public DogBreedResponse {
    }

    public static DogBreedResponse getResponse(DogBreed breed) {
        return new DogBreedResponse(breed.getIdDogBreed(), breed.getName());
    }
}

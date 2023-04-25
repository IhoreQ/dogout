package pl.dogout.app.dto.mapper;

import pl.dogout.app.dto.response.DogInfoResponse;
import pl.dogout.app.model.Dog;

public class DogInfoMapper {

    public DogInfoResponse getDogInfoResponse(Dog dog) {

        String gender = dog.getGender() ? "Male" : "Female";
        String breed = dog.getDogsBreedByIdBreed().getName();
        String size = dog.getDogsBreedByIdBreed().getDogsSizesByIdDogSize().getName();

        return new DogInfoResponse(dog.getName(), dog.getAge(), breed, gender, size, dog.getDescription(), dog.getPhoto());
    }


}

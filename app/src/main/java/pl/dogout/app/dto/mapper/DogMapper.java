package pl.dogout.app.dto.mapper;

import pl.dogout.app.dto.response.DogInfoResponse;
import pl.dogout.app.model.Dog;

public class DogMapper {

    public DogInfoResponse getDogInfoResponse(Dog dog) {

        String gender = dog.getGender() ? "Male" : "Female";
        String breed = dog.getBreed().getName();
        String size = dog.getBreed().getSize().getName();

        return new DogInfoResponse(dog.getName(), dog.getAge(), breed, gender, size, dog.getDescription(), dog.getPhoto());
    }


}

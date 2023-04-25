package pl.dogout.app.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public record DogAddRequest(String email, String name, int age, String breed, boolean gender, String description, String photo) {
    @JsonCreator
    public DogAddRequest {
    }
}

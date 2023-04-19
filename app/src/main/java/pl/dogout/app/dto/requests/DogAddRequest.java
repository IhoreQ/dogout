package pl.dogout.app.dto.requests;

import com.fasterxml.jackson.annotation.JsonCreator;

public record DogAddRequest(String name, int age, String breed, boolean gender, String description, String photo) {
    @JsonCreator
    public DogAddRequest {
    }
}

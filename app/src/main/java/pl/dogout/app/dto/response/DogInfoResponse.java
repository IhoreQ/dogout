package pl.dogout.app.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;

public record DogInfoResponse(String name,
                              int age,
                              String breed,
                              String gender,
                              String size,
                              String description,
                              String photo) {
    @JsonCreator
    public DogInfoResponse {}
}

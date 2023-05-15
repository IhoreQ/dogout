package pl.dogout.app.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public record DogAddRequest(String email,
                            String name,
                            int age,
                            Long breedId,
                            boolean gender,
                            String description,
                            String photo) {
    @JsonCreator
    public DogAddRequest {
    }
}

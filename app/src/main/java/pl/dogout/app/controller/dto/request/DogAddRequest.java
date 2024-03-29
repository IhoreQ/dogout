package pl.dogout.app.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public record DogAddRequest(String name,
                            int age,
                            Long breedId,
                            boolean gender,
                            String description) {
    @JsonCreator
    public DogAddRequest {
    }
}

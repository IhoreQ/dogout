package pl.dogout.app.dto.responses;

import pl.dogout.app.dto.requests.DogAddRequest;

public record DogInfoResponse(String name,
                              int age,
                              String breed,
                              boolean gender,
                              String description,
                              String photo) {}

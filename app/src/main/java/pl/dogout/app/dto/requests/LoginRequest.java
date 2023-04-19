package pl.dogout.app.dto.requests;

import com.fasterxml.jackson.annotation.JsonCreator;

public record LoginRequest(String email, String password) {
    @JsonCreator
    public LoginRequest {}
}

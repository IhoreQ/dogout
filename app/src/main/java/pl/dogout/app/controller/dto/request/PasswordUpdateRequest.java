package pl.dogout.app.controller.dto.request;

public record PasswordUpdateRequest(String email,
                                    String newPassword) {
    public PasswordUpdateRequest {}
}

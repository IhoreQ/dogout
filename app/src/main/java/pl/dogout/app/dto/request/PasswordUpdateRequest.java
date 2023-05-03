package pl.dogout.app.dto.request;

public record PasswordUpdateRequest(String email,
                                    String newPassword) {
    public PasswordUpdateRequest {}
}

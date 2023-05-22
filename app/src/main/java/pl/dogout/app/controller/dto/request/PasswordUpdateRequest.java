package pl.dogout.app.controller.dto.request;

public record PasswordUpdateRequest(String oldPassword,
                                    String newPassword,
                                    String repeatedNewPassword) {
    public PasswordUpdateRequest {}
}

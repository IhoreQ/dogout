package pl.dogout.app.payload.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class LoginRequest {

    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
    private String password;
}

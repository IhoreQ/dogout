package pl.dogout.app.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SignupRequest {

    private String email;

    private String password;

    private String name;

    private String surname;

}

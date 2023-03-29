package pl.dogout.app.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dogout.app.payload.request.LoginRequest;
import pl.dogout.app.payload.request.SignupRequest;
import pl.dogout.app.payload.response.MessageResponse;
import pl.dogout.app.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        return ResponseEntity.ok(new MessageResponse("User logged in successfully!"));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(SignupRequest signupRequest) {
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok(new MessageResponse("User logged out!"));
    }


}

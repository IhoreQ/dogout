package pl.dogout.app.controllers;

import org.apache.coyote.Response;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.payload.request.LoginRequest;
import pl.dogout.app.payload.request.SignupRequest;
import pl.dogout.app.payload.response.MessageResponse;
import pl.dogout.app.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser() {
        return ResponseEntity.ok("Okej");
    }

    @PostMapping("/signup")
    public String registerUser(SignupRequest signupRequest) {
        return "User registered successfully!";
    }

    @PostMapping("/logout")
    public ResponseEntity<MessageResponse> logout() {
        return ResponseEntity.ok(new MessageResponse("User logged out!"));
    }

}

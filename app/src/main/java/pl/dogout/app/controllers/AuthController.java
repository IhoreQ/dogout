package pl.dogout.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public String registerUser() {
        return "User registered successfully!";
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("User logged out!");
    }

}

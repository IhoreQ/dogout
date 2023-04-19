package pl.dogout.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.dto.requests.LoginRequest;
import pl.dogout.app.dto.responses.JwtTokenResponse;
import pl.dogout.app.repository.UserRepository;
import pl.dogout.app.service.AuthService;
import pl.dogout.app.service.JwtService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @Autowired
    public AuthController(AuthService authService, JwtService jwtService, AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authService = authService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @PostMapping("/authenticate")
    public JwtTokenResponse authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

        if (authentication.isAuthenticated())
            return new JwtTokenResponse(jwtService.generateToken(loginRequest.email()));
        else
            throw new UsernameNotFoundException("User does not exist!");
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

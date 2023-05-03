package pl.dogout.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import pl.dogout.app.dto.request.LoginRequest;
import pl.dogout.app.dto.request.PasswordUpdateRequest;
import pl.dogout.app.dto.request.UserAddRequest;
import pl.dogout.app.dto.response.JwtTokenResponse;
import pl.dogout.app.model.User;
import pl.dogout.app.service.AuthService;
import pl.dogout.app.service.JwtService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Autowired
    public AuthController(AuthService authService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/authenticate")
    public JwtTokenResponse authenticateUser(@RequestBody LoginRequest loginRequest) throws UsernameNotFoundException {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

        if (authentication.isAuthenticated())
            return new JwtTokenResponse(jwtService.generateToken(loginRequest.email()));
        else
            throw new UsernameNotFoundException("User does not exist!");
    }

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody UserAddRequest request) {

        if (authService.userExists(request)) {
            throw new RuntimeException("User with this email already exists!");
        }

        User user = authService.addUser(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("User logged out!");
    }

}

package pl.dogout.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dogout.app.dto.request.UserAddRequest;
import pl.dogout.app.model.User;
import pl.dogout.app.model.UserDetails;
import pl.dogout.app.repository.UserRepository;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User addUser(UserAddRequest request) {

        User user = new User(request.email(), new UserDetails(request.firstName(), request.lastName()));
        user.setPassword(passwordEncoder.encode(request.password()));

        return userRepository.save(user);
    }

    public boolean userExists(UserAddRequest request) {
        return userRepository.existsByEmail(request.email());
    }

}

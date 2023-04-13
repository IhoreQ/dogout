package pl.dogout.app.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dogout.app.repository.UserRepository;


@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

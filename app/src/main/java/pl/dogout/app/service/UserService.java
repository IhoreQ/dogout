package pl.dogout.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dogout.app.model.User;
import pl.dogout.app.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    public void changeHasDogState(User user) {
        boolean actualState = user.hasDog();
        user.setHasDog(!actualState);
        userRepository.save(user);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}

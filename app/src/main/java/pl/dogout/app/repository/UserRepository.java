package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dogout.app.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

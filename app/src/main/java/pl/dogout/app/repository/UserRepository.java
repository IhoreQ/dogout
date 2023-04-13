package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dogout.app.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}

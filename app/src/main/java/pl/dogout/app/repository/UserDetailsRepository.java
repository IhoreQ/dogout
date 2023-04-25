package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dogout.app.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {}

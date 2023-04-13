package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dogout.app.models.Dog;

public interface DogRepository extends JpaRepository<Dog, Long> {
}

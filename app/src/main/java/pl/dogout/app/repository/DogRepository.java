package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dogout.app.models.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {}

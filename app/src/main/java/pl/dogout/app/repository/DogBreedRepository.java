package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dogout.app.model.DogBreed;

import java.util.Optional;

@Repository
public interface DogBreedRepository extends JpaRepository<DogBreed, Long> {

    Optional<DogBreed> findByName(String name);
}

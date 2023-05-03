package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dogout.app.model.Image;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String name);
}

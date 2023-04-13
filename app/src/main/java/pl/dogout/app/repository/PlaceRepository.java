package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dogout.app.models.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}

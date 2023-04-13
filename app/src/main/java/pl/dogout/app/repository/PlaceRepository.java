package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dogout.app.models.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {}

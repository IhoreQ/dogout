package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dogout.app.model.ActiveWalk;
import pl.dogout.app.model.Place;

import java.util.List;

@Repository
public interface WalkRepository extends JpaRepository<ActiveWalk, Long> {

    List<ActiveWalk> findAllByPlacesByIdPlace(Place placesByIdPlace);
}

package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dogout.app.model.ActiveWalk;
import pl.dogout.app.model.Place;
import pl.dogout.app.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalkRepository extends JpaRepository<ActiveWalk, Long> {

    List<ActiveWalk> findAllByPlace(Place place);

    Optional<ActiveWalk> findByUser(User user);
}

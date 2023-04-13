package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dogout.app.models.ActiveWalk;

@Repository
public interface WalkRepository extends JpaRepository<ActiveWalk, Long> {}

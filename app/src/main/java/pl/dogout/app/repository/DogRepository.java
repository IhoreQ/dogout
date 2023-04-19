package pl.dogout.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dogout.app.model.Dog;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    @Query("SELECT aw.idActiveWalk, aw.timeOfWalk, aw.startedAt, 'time(now)' as now, d.name AS dogName, db.name AS dogBreed, ds.name AS dogSize, d.age, d.gender FROM Dog d " +
            "JOIN d.dogsBreedByIdBreed db " +
            "JOIN db.dogsSizesByIdDogSize ds " +
            "JOIN d.usersByIdUser u " +
            "JOIN u.activeWalksByIdUser aw " +
            "WHERE aw.placesByIdPlace.idPlace = 2")
    List<Dog> getDogsFromPlace();
}

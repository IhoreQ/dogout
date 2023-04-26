package pl.dogout.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dogout.app.dto.mapper.WalkMapper;
import pl.dogout.app.dto.response.UserActiveWalkResponse;
import pl.dogout.app.model.ActiveWalk;
import pl.dogout.app.model.User;
import pl.dogout.app.repository.DogRepository;
import pl.dogout.app.repository.PlaceRepository;
import pl.dogout.app.repository.UserRepository;
import pl.dogout.app.repository.WalkRepository;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;

@Service
public class WalkService {

    private final WalkRepository walkRepository;
    private final UserRepository userRepository;
    private final DogRepository dogRepository;
    private final PlaceRepository placeRepository;

    @Autowired
    public WalkService(WalkRepository walkRepository, UserRepository userRepository, DogRepository dogRepository, PlaceRepository placeRepository) {
        this.walkRepository = walkRepository;
        this.userRepository = userRepository;
        this.dogRepository = dogRepository;
        this.placeRepository = placeRepository;
    }


    public ActiveWalk getActiveWalkByUser(User user) {
        Optional<ActiveWalk> walk = user.getActiveWalksByIdUser().stream().findFirst();
        ActiveWalk activeWalk;

        if (walk.isEmpty())
            return null;

        activeWalk = walk.get();

        if (checkIfTimeExceeded(activeWalk)) {
            finishWalk(activeWalk);
            return null;
        }

        return activeWalk;
    }

    private void finishWalk(ActiveWalk activeWalk) {
        walkRepository.delete(activeWalk);
    }

    private boolean checkIfTimeExceeded(ActiveWalk activeWalk) {
        LocalTime now = LocalTime.now();
        LocalTime startedAt = activeWalk.getStartedAt();
        LocalTime duration = LocalTime.parse(activeWalk.getTimeOfWalk());

        LocalTime endTime = now.plusHours(duration.getHour())
                .plusMinutes(duration.getMinute())
                .plusSeconds(duration.getSecond());

        return now.isAfter(endTime) || now.isBefore(startedAt);
    }

    public void saveWalk(ActiveWalk activeWalk) {
        walkRepository.save(activeWalk);
    }
}

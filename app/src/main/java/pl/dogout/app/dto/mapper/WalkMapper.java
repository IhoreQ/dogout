package pl.dogout.app.dto.mapper;

import pl.dogout.app.dto.response.UserActiveWalkResponse;
import pl.dogout.app.model.ActiveWalk;

import java.time.LocalTime;

public class WalkMapper {

    public UserActiveWalkResponse getUserActiveWalkResponse(ActiveWalk activeWalk, LocalTime timeLeft) {
        return new UserActiveWalkResponse(activeWalk.getIdActiveWalk(), timeLeft, activeWalk.getPlace().getName(), activeWalk.getPlace().getPhoto());
    }
}

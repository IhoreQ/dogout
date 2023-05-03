package pl.dogout.app.dto.mapper;

import pl.dogout.app.dto.response.UserActiveWalkResponse;
import pl.dogout.app.model.ActiveWalk;

public class WalkMapper {

    public UserActiveWalkResponse getUserActiveWalkResponse(ActiveWalk activeWalk) {
        return new UserActiveWalkResponse(activeWalk.getIdActiveWalk(), activeWalk.getStartedAt(), activeWalk.getPlace().getName());
    }
}

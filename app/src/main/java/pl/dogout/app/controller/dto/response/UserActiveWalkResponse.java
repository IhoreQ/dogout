package pl.dogout.app.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import pl.dogout.app.model.ActiveWalk;

import java.time.LocalTime;

public record UserActiveWalkResponse(Long walkId,
                                     LocalTime timeLeft,
                                     String placeName,
                                     String photo) {

    @JsonCreator
    public UserActiveWalkResponse {}

    public static UserActiveWalkResponse getResponse(ActiveWalk activeWalk, LocalTime timeLeft) {
        return new UserActiveWalkResponse(activeWalk.getIdActiveWalk(), timeLeft, activeWalk.getPlace().getName(), activeWalk.getPlace().getPhoto());
    }
}

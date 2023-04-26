package pl.dogout.app.dto.mapper;

import pl.dogout.app.dto.response.PlaceWalksResponse;
import pl.dogout.app.dto.response.UserActiveWalkResponse;
import pl.dogout.app.model.ActiveWalk;
import pl.dogout.app.model.Place;

public class WalkMapper {

    public UserActiveWalkResponse getUserActiveWalkResponse(ActiveWalk activeWalk) {
        return new UserActiveWalkResponse(activeWalk.getIdActiveWalk(), activeWalk.getStartedAt(), activeWalk.getPlacesByIdPlace().getName());
    }

    public PlaceWalksResponse getPlaceWalksResponse(ActiveWalk activeWalk, Place place) {
        return null;
    }
}

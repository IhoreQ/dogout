package pl.dogout.app.controller.dto.request;

public record WalkStartRequest(String email,
                               String timeOfAWalk,
                               Long placeId) {

    public WalkStartRequest {}
}

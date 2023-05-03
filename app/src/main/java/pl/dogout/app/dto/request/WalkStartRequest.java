package pl.dogout.app.dto.request;

public record WalkStartRequest(String email,
                               String timeOfAWalk,
                               Long placeId) {

    public WalkStartRequest {}
}

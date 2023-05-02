package pl.dogout.app.dto.response;

import java.time.LocalTime;

public record UserActiveWalkResponse(Long walkId,
                                     LocalTime startedAt,
                                     String placeName) {}

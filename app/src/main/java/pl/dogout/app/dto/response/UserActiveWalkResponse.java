package pl.dogout.app.dto.response;

import java.time.LocalTime;
import java.util.Date;

public record UserActiveWalkResponse(Long walkId,
                                     LocalTime startedAt,
                                     String placeName) {}

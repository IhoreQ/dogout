package pl.dogout.app.dto.response;

import java.util.Date;

public record PlaceWalksResponse (Long walkId,
                                 String walkTime,
                                 Date startedAt,
                                 Date now,
                                 String dogName,
                                 String dogBreed,
                                 String dogSize,
                                 int dogAge,
                                 String dogGender) {}

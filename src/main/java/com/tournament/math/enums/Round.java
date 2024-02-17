package com.tournament.math.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Round {
    FINAL(1, "Final"),
    SEMI_FINAL(2, "Semi-final"),
    QUARTER_FINAL(3, "Quartas de final"),
    EIGHTH_FINAL(4, "Oitavas de final"),
    SIXTEENTH_FINAL(5, "16 avos de final"),
    THIRTY_SECOND_FINAL(6, "32 avos de final"),
    SIXTY_FOURTH_FINAL(7, "64 avos de final"),
    ONE_HUNDRED_TWENTY_EIGHTH_FINAL(8, "128 avos de final"),
    TWO_HUNDRED_FIFTY_SIXTH_FINAL(9, "256 avos de final"),
    FIVE_HUNDRED_TWELFTH_FINAL(10, "512 avos de final");

    private final int id;
    private final String name;

    public static Round getById(Integer id) {
        for (Round round : values()) {
            if (round.id == id) {
                return round;
            }
        }
        throw new IllegalArgumentException("No round found with id: " + id);
    }

}

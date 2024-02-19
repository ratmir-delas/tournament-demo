package com.tournament.math.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Region {
    ALENTEJO("Alentejo"),
    ALGARVE("Algarve"),
    CENTRO("Centro"),
    LISBOA("Lisboa"),
    NORTE("Norte"),
    ACORES("Açores"),
    MADEIRA("Madeira");

    private final String name;

    public static Region getRegionByName(String name) {
        for (Region region : Region.values()) {
            if (region.getName().equals(name)) {
                return region;
            }
        }
        return null;
    }
}

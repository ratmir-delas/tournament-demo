package com.tournament.math.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum District {
    AVEIRO("Aveiro", Region.CENTRO),
    BEJA("Beja", Region.ALENTEJO),
    BRAGA("Braga", Region.NORTE),
    BRAGANCA("Bragança", Region.NORTE),
    CASTELO_BRANCO("Castelo Branco", Region.CENTRO),
    COIMBRA("Coimbra", Region.CENTRO),
    EVORA("Évora", Region.ALENTEJO),
    FARO("Faro", Region.ALGARVE),
    GUARDA("Guarda", Region.CENTRO),
    LEIRIA("Leiria", Region.CENTRO),
    LISBOA("Lisboa", Region.LISBOA),
    PORTALEGRE("Portalegre", Region.ALENTEJO),
    PORTO("Porto", Region.NORTE),
    SANTAREM("Santarém", Region.LISBOA),
    SETUBAL("Setúbal", Region.LISBOA),
    VIANA_DO_CASTELO("Viana do Castelo", Region.NORTE),
    VILA_REAL("Vila Real", Region.NORTE),
    VISEU("Viseu", Region.CENTRO),
    MADEIRA("Madeira", Region.MADEIRA),
    ACORES("Açores", Region.ACORES);

    private final String name;
    private final Region region;

    public static District getDistrictByName(String name) {
        for (District district : District.values()) {
            if (district.getName().equalsIgnoreCase(name)) {
                return district;
            }
        }
        return null;
    }
}

package com.tournament.math.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum District {
    AVEIRO("Aveiro"),
    BEJA("Beja"),
    BRAGA("Braga"),
    BRAGANCA("Bragança"),
    CASTELO_BRANCO("Castelo Branco"),
    COIMBRA("Coimbra"),
    EVORA("Évora"),
    FARO("Faro"),
    GUARDA("Guarda"),
    LEIRIA("Leiria"),
    LISBOA("Lisboa"),
    PORTALEGRE("Portalegre"),
    PORTO("Porto"),
    SANTAREM("Santarém"),
    SETUBAL("Setúbal"),
    VIANA_DO_CASTELO("Viana do Castelo"),
    VILA_REAL("Vila Real"),
    VISEU("Viseu"),
    MADEIRA("Madeira"),
    ACORES("Açores");

    private final String name;
}

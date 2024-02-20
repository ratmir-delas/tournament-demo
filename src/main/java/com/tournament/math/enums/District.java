package com.tournament.math.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum District {
    AVEIRO(0, "Aveiro", Region.CENTRO),
    BEJA(1, "Beja", Region.ALENTEJO),
    BRAGA(2, "Braga", Region.NORTE),
    BRAGANCA(3, "Bragança", Region.NORTE),
    CASTELO_BRANCO(4, "Castelo Branco", Region.CENTRO),
    COIMBRA(5, "Coimbra", Region.CENTRO),
    EVORA(6, "Évora", Region.ALENTEJO),
    FARO(7, "Faro", Region.ALGARVE),
    GUARDA(8, "Guarda", Region.CENTRO),
    LEIRIA(9, "Leiria", Region.CENTRO),
    LISBOA(10, "Lisboa", Region.LISBOA),
    PORTALEGRE(11, "Portalegre", Region.ALENTEJO),
    PORTO(12, "Porto", Region.NORTE),
    SANTAREM(13, "Santarém", Region.LISBOA),
    SETUBAL(14, "Setúbal", Region.LISBOA),
    VIANA_DO_CASTELO(15, "Viana do Castelo", Region.NORTE),
    VILA_REAL(16, "Vila Real", Region.NORTE),
    VISEU(17, "Viseu", Region.CENTRO),
    MADEIRA(18, "Madeira", Region.MADEIRA),
    ACORES(19, "Açores", Region.ACORES);

    @JsonValue
    private final int id;
    private final String name;
    private final Region region;

    public static District getById(int id) {
        for (District district : District.values()) {
            if (district.getId() == id) {
                return district;
            }
        }
        return null;
    }

    public static District getByName(String name) {
        for (District district : District.values()) {
            if (district.getName().equalsIgnoreCase(name)) {
                return district;
            }
        }
        return null;
    }

    public static District getByRegion(Region region) {
        for (District district : District.values()) {
            if (district.getRegion().equals(region)) {
                return district;
            }
        }
        return null;
    }

    public static String[] getDistrictNames() {
        String[] names = new String[District.values().length];
        for (int i = 0; i < District.values().length; i++) {
            names[i] = District.values()[i].getName();
        }
        return names;
    }

    public static boolean existsById(int id) {
        for (District district : District.values()) {
            if (district.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static boolean existsByName(String name) {
        for (District district : District.values()) {
            if (district.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

}

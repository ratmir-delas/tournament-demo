package com.tournament.math.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum Category {
    FIRST(1, "Primeira", "Primeiro", List.of(Game.GATOS_E_CAES, Game.RASTROS, Game.PRODUTO)),
    SECOND(2, "Segunda", "Segundo", List.of(Game.RASTROS, Game.PRODUTO, Game.DOMINORIO)),
    THIRD(3, "Terceira", "Terceiro", List.of(Game.PRODUTO, Game.DOMINORIO, Game.ATARI_GO)),
    FOURTH(4, "Quarta", "Secundário", List.of(Game.DOMINORIO, Game.ATARI_GO, Game.NEX));

    private final int id;
    private final String name;
    private final String cycle;
    private final List<Game> games;

    public static Category getById(Integer id) {
        for (Category category : values()) {
            if (category.id == id) {
                return category;
            }
        }
        throw new IllegalArgumentException("No category found with id: " + id);
    }

    public static List<Category> getAll() {
        return List.of(FIRST, SECOND, THIRD, FOURTH);
    }

}

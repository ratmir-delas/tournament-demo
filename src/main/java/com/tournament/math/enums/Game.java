package com.tournament.math.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Game {
    GATOS_E_CAES(1, "Gatos e Cães"),
    RASTROS(2, "Rastros"),
    PRODUTO(3, "Produto"),
    DOMINORIO(4, "Dominório"),
    ATARI_GO(5, "Atari Go"),
    NEX(6, "NEX");

    private final int id;
    private final String name;

    public static Game getById(Integer id) {
        for (Game game : values()) {
            if (game.id == id) {
                return game;
            }
        }
        throw new IllegalArgumentException("No game found with id: " + id);
    }
}

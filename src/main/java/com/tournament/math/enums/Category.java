package com.tournament.math.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    FIRST(1, "Primeira", "Primeiro", new int[]{1, 2, 3}),
    SECOND(2, "Segunda", "Segundo", new int[]{2, 3, 4}),
    THIRD(3, "Terceira", "Terceiro", new int[]{3, 4, 5}),
    FOURTH(4, "Quarta", "Secundário", new int[]{4, 5, 6});

    private final int id;
    private final String name;
    private final String cycle;
    private final int[] games;

    public static Category getById(Integer id) {
        for (Category category : values()) {
            if (category.id == id) {
                return category;
            }
        }
        throw new IllegalArgumentException("No category found with id: " + id);
    }

}

package com.tournament.math.participants.players;

import com.tournament.math.enums.Category;
import com.tournament.math.enums.Game;
import com.tournament.math.participants.schools.School;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_player")
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String name;
    @Enumerated
    private Category category;
    @Enumerated
    private Game game;
    @ManyToOne(fetch = FetchType.EAGER)
    private School school;
}

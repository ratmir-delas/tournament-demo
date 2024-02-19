package com.tournament.math.matches;

import com.tournament.math.enums.Category;
import com.tournament.math.enums.Game;
import com.tournament.math.participants.players.Player;
import com.tournament.math.participants.schools.School;
import com.tournament.math.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_match")
@RedisHash("Match")
public class Match {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    // Category and Game
    @Enumerated
    private Game game;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Long endedAt;
    private Long startedAt;
    // Participants
    @ManyToOne
    private Player player1;
    @ManyToOne
    private School school1;
    @ManyToOne
    private Player player2;
    @ManyToOne
    private School school2;
    // Results
    private int score1;
    private int score2;
    @ManyToOne
    private Player winner;
    @ManyToOne
    private School winnerSchool;
    // Metadata
    @ManyToOne
    private User createdBy;
    private Long createdAt;
    @ManyToOne
    private User updatedBy;
    private Long updatedAt;

    public Player getLooser() {
        if (player1.equals(winner)) {
            return player2;
        } else {
            return player1;
        }
    }

    public School getLooserSchool() {
        if (school1.equals(winner.getSchool())) {
            return school2;
        } else {
            return school1;
        }
    }

}

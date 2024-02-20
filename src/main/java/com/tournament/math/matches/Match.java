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

import java.util.List;

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
    @Enumerated

    private Category category;
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
    private int roundNumber;
    // winner
    private boolean isPlayer1Winner;
    // Metadata
    @ManyToOne
    private User createdBy;
    private Long createdAt;
    @ManyToOne
    private User updatedBy;
    private Long updatedAt;

    public Match(Player player1, School school1, Player player2, School school2, boolean isPlayer1Winner, Game game, Category category, Integer roundNumber) {
        this.player1 = player1;
        this.school1 = school1;
        this.player2 = player2;
        this.school2 = school2;
        this.isPlayer1Winner = isPlayer1Winner;
        this.game = game;
        this.category = category;
        this.roundNumber = roundNumber;
        this.createdAt = System.currentTimeMillis();
    }

    public Player getWinner() {
        return isPlayer1Winner ? player1 : player2;
    }

    public Player getLoser() {
        return isPlayer1Winner ? player2 : player1;
    }

    public List<School> getSchools() {
        return List.of(school1, school2);
    }

}

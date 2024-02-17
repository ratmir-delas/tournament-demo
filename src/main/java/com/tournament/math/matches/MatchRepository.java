package com.tournament.math.matches;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatchRepository extends JpaRepository<Match, Integer> {
    @Query("SELECT m FROM Match m WHERE m.player1.id = ?1 OR m.player2.id = ?1")
    public Match findMatchesByUserId(Integer userId);

    @Query("SELECT m FROM Match m WHERE m.school1.id = ?1 OR m.school2.id = ?1")
    public Match findMatchesBySchoolId(Integer schoolId);

    @Query("SELECT m FROM Match m WHERE m.game.id = ?1 AND m.category = ?2")
    public Match findMatchesByGameIdAndCategoryId(Long gameId, Integer categoryId);
}

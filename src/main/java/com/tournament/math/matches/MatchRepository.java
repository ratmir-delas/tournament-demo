package com.tournament.math.matches;

import com.tournament.math.enums.Category;
import com.tournament.math.enums.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatchRepository extends JpaRepository<Match, Long> {
    @Query("SELECT m FROM Match m WHERE m.player1.id = ?1 OR m.player2.id = ?1")
    public Match findMatchesByUserId(Integer userId);

    @Query("SELECT m FROM Match m WHERE m.school1.id = ?1 OR m.school2.id = ?1")
    public Iterable<Match> findMatchesBySchoolId(Integer schoolId);

    @Query("SELECT m FROM Match m WHERE m.game = ?1 AND m.category = ?2")
    public Iterable<Match> findMatchesByGameIdAndCategoryId(int matchId, int categoryId);
}

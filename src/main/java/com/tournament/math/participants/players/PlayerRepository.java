package com.tournament.math.participants.players;

import com.tournament.math.enums.Category;
import com.tournament.math.enums.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findBySchoolId(Long schoolId);
    List<Player> findByCategoryAndGame(Category category, Game game);
}

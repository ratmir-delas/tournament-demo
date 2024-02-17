package com.tournament.math.participants.players;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository repository;

    public Player findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Player> findBySchoolId(Long schoolId) {
        return repository.findBySchoolId(schoolId);
    }

    public Player save(Player player) {
        return repository.save(player);
    }

    public Player update(Player player) {
        if (repository.existsById(player.getId())) {
            return repository.save(player);
        } else {
            throw new RuntimeException("Player not found for update with id: " + player.getId());
        }
    }

    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Player not found for detele with id: " + id);
        }
    }

}

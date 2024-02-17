package com.tournament.math.matches;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository repository;

    public Match findMatchesByUserId(Integer userId) {
        return repository.findMatchesByUserId(userId);
    }

    public Match findMatchesBySchoolId(Integer schoolId) {
        return repository.findMatchesBySchoolId(schoolId);
    }

    public Match save(Match match) {
        return repository.save(match);
    }

    public Match update(Match match) {
        if (repository.existsById(match.getId())) {
            return repository.save(match);
        } else {
            throw new RuntimeException("Match for update not found");
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}

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
}

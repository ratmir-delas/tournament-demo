package com.tournament.math.matches;

import com.tournament.math.participants.schools.School;

public interface MatchProjection {
    Long getId();
    School getSchool1();
    int getScore1();
    School getSchool2();
    int getScore2();
    School getWinnerSchool();
}

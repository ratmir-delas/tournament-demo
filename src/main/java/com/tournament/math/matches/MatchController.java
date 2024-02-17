package com.tournament.math.matches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @RequestMapping("/user/{userId}")
    public Match findMatchesByUserId(@PathVariable Integer userId) {
        return matchService.findMatchesByUserId(userId);
    }

    @RequestMapping("/school/{schoolId}")
    public Match findMatchesBySchoolId(@PathVariable Integer schoolId) {
        return matchService.findMatchesBySchoolId(schoolId);
    }

}

package com.tournament.math.participants.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping("/{id}")
    public Player findById(@PathVariable Long id) {
        return playerService.findById(id);
    }

    @RequestMapping("/save")
    public Player save(Player player) {
        return playerService.save(player);
    }

    @RequestMapping("/update")
    public Player update(Player player) {
        return playerService.update(player);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }
}

package dev.dredomt.moria.dnd.controller;

import dev.dredomt.moria.dnd.model.Player;
import dev.dredomt.moria.dnd.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/dnd/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Integer id) {
        return playerService.getPlayerById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Player createPlayer(@Validated @RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Player updatePlayer(@Validated@RequestBody Player player, @PathVariable Integer id) {
        player.setId(id);
        return playerService.savePlayer(player);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }
}

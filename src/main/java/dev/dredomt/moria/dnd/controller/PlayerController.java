package dev.dredomt.moria.dnd.controller;

import dev.dredomt.moria.dnd.dto.PlayerDTO;
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
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public PlayerDTO getPlayerById(@PathVariable Integer id) {
        return playerService.getPlayerById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public PlayerDTO createPlayer(@Validated @RequestBody PlayerDTO playerDTO) {
        return playerService.createPlayer(playerDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public PlayerDTO updatePlayer(@Validated@RequestBody PlayerDTO playerDTO, @PathVariable Integer id) {

        return playerService.updatePlayer(id,playerDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }
}

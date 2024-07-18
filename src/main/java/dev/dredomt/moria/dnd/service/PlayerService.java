package dev.dredomt.moria.dnd.service;

import dev.dredomt.moria.dnd.Exceptions.PlayerNotFoundException;
import dev.dredomt.moria.dnd.model.Player;
import dev.dredomt.moria.dnd.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return ( playerRepository.findAll());
    }

    public Player getPlayerById(Integer id) {
        Optional<Player> player = playerRepository.findById(id);
        if(player.isEmpty()) {
            throw new PlayerNotFoundException();
        }
        return player.get();
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }
}

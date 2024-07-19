package dev.dredomt.moria.dnd.service;

import dev.dredomt.moria.dnd.Exceptions.PlayerNotFoundException;
import dev.dredomt.moria.dnd.dto.PlayerDTO;
import dev.dredomt.moria.dnd.dto.PlayerMapper;
import dev.dredomt.moria.dnd.model.Player;
import dev.dredomt.moria.dnd.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerMapper playerMapper;

    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(playerMapper::toDto)
                .collect(Collectors.toList());
    }

    public PlayerDTO getPlayerById(Integer id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(PlayerNotFoundException::new);
        return playerMapper.toDto(player);
    }

    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        Player player = playerMapper.toEntity(playerDTO);
        player = playerRepository.save(player);
        return playerMapper.toDto(player);
    }

    public PlayerDTO updatePlayer(Integer id, PlayerDTO playerDTO) {
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(PlayerNotFoundException::new);
        existingPlayer.setName(playerDTO.getName());
        existingPlayer.setEmail(playerDTO.getEmail());
        existingPlayer.setUsername(playerDTO.getUsername());
        existingPlayer.setExperience(playerDTO.getExperience());
        // Update other fields as needed

        Player updatedPlayer = playerRepository.save(existingPlayer);
        return playerMapper.toDto(updatedPlayer);
    }

    public void deletePlayer(Integer id) {
        Player player = playerRepository.findById(id)
                        .orElseThrow(PlayerNotFoundException::new);
        playerRepository.deleteById(id);
    }
}

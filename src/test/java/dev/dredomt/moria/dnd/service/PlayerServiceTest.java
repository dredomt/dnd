package dev.dredomt.moria.dnd.service;

import dev.dredomt.moria.dnd.Exceptions.PlayerNotFoundException;
import dev.dredomt.moria.dnd.dto.PlayerDTO;
import dev.dredomt.moria.dnd.dto.PlayerMapper;
import dev.dredomt.moria.dnd.model.Player;
import dev.dredomt.moria.dnd.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {
    Logger logger = LoggerFactory.getLogger(PlayerServiceTest.class);


    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private PlayerMapper playerMapper;

    @InjectMocks
    private PlayerService playerService;


    private Player player;
    private Player player2;
    private PlayerDTO playerDTO;
    private PlayerDTO playerDTO2;

    @BeforeEach
    public void setup() {
        player = new Player();
        player.setId(1);
        player.setName("Test Player");
        player.setEmail("test@test");
        player.setUsername("test");
        player.setExperience("Experienced");

        playerDTO = new PlayerDTO();
        playerDTO.setId(1);
        playerDTO.setName("Test Player");
        playerDTO.setEmail("test@test");
        playerDTO.setUsername("test");
        playerDTO.setExperience("Experienced");


        player2 = new Player();
        player2.setId(2);
        player2.setName("Test Player2");
        player2.setEmail("test2@test");
        player2.setUsername("test2");
        player2.setExperience("Beginner");


        playerDTO2 = new PlayerDTO();
        playerDTO2.setId(2);
        playerDTO2.setName("Test Player2");
        playerDTO2.setEmail("test2@test");
        playerDTO2.setUsername("test2");
        playerDTO2.setExperience("Beginner");
    }


    @Test
    public void testCreatePlayer() {
        when(playerMapper.toEntity(playerDTO)).thenReturn(player);
        when(playerRepository.save(player)).thenReturn(player);
        when(playerMapper.toDto(player)).thenReturn(playerDTO);

        PlayerDTO createdPlayerDTO = playerService.createPlayer(playerDTO);

        assertNotNull(createdPlayerDTO);
        assertEquals("Test Player", createdPlayerDTO.getName());
        verify(playerRepository, times(1)).save(player);
    }

    @Test
    public void testUpdatePlayer() {
        when(playerRepository.findById(playerDTO.getId())).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(player);
        when(playerMapper.toDto(player)).thenReturn(playerDTO);

        PlayerDTO updatedPlayerDTO = playerService.updatePlayer(playerDTO.getId(), playerDTO);

        assertNotNull(updatedPlayerDTO);
        assertEquals("Test Player", updatedPlayerDTO.getName());
        verify(playerRepository, times(1)).save(player);
    }

    @Test
    public void testGetPlayerById() {
        when(playerRepository.findById(playerDTO.getId())).thenReturn(Optional.of(player));
        when(playerMapper.toDto(player)).thenReturn(playerDTO);

        PlayerDTO foundPlayerDTO = playerService.getPlayerById(playerDTO.getId());

        assertNotNull(foundPlayerDTO);
        assertEquals("Test Player", foundPlayerDTO.getName());
    }

    @Test
    public void testGetPlayerByIdNotFound() {
        when(playerRepository.findById(playerDTO.getId())).thenReturn(Optional.empty());
        assertThrows(PlayerNotFoundException.class, () -> playerService.getPlayerById(playerDTO.getId()));
        verify(playerRepository, times(1)).findById(playerDTO.getId());
    }

    @Test
    public void testGetAllPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(player);
        players.add(player2);
        when(playerRepository.findAll()).thenReturn(players);

        List<PlayerDTO> playersDTO = playerService.getAllPlayers();

        assertEquals(2, playersDTO.size());
        verify(playerRepository, times(1)).findAll();
    }

    @Test
    public void testDeletePlayer() {
        when(playerRepository.findById(playerDTO.getId())).thenReturn(Optional.of(player));
        playerService.deletePlayer(playerDTO.getId());
        verify(playerRepository, times(1)).deleteById(playerDTO.getId());
    }

    @Test
    public void testDeletePlayerNotFound() {
        when(playerRepository.findById(playerDTO.getId())).thenReturn(Optional.empty());
        assertThrows(PlayerNotFoundException.class, () -> playerService.deletePlayer(playerDTO.getId()));
        verify(playerRepository, times(0)).deleteById(playerDTO.getId());
    }
}

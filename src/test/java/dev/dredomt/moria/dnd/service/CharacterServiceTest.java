package dev.dredomt.moria.dnd.service;

import dev.dredomt.moria.dnd.Exceptions.CharacterNotFoundException;
import dev.dredomt.moria.dnd.dto.CharacterDTO;
import dev.dredomt.moria.dnd.dto.CharacterMapper;
import dev.dredomt.moria.dnd.dto.PlayerDTO;
import dev.dredomt.moria.dnd.model.Campaign;
import dev.dredomt.moria.dnd.model.Player;
import dev.dredomt.moria.dnd.repository.CampaignRepository;
import dev.dredomt.moria.dnd.repository.CharacterRepository;
import dev.dredomt.moria.dnd.repository.PlayerRepository;
import dev.dredomt.moria.dnd.model.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CharacterServiceTest {

    @Mock
    private CharacterRepository characterRepository;
    @Mock
    private PlayerRepository playerRepository;
    @Mock
    private CampaignRepository campaignRepository;
    @Mock
    private CharacterMapper characterMapper;

    @InjectMocks
    private CharacterService characterService;

    private Character character;
    private Character character2;
    private CharacterDTO characterDTO;
    private CharacterDTO characterDTO2;

    @BeforeEach
    void setup() {
        character = new Character();
        character.setId(1);
        character.setName("Test Character");
        character.setRace("Human");
        character.setCharacterClass("Warrior");
        character.setCharacterLevel("1");
        character.setPlayer(new Player());
        character.setCampaign(new Campaign());

        characterDTO = new CharacterDTO();
        characterDTO.setId(1);
        characterDTO.setName("Test Character");
        characterDTO.setRace("Human");
        characterDTO.setCharacterClass("Warrior");
        characterDTO.setCharacterLevel("1");
        characterDTO.setPlayerId(1);
        characterDTO.setCampaignId(1);

        character2 = new Character();
        character2.setId(2);
        character2.setName("Test Character2");
        character2.setRace("Dwarf");
        character2.setCharacterClass("Mage");
        character2.setCharacterLevel("2");
        character2.setPlayer(new Player());
        character2.setCampaign(new Campaign());

        characterDTO2 = new CharacterDTO();
        characterDTO2.setId(2);
        characterDTO2.setName("Test Character2");
        characterDTO2.setRace("Dwarf");
        characterDTO2.setCharacterClass("Mage");
        characterDTO2.setCharacterLevel("2");
        characterDTO2.setPlayerId(2);
        characterDTO2.setCampaignId(2);
    }

    @Test
    public void testCreateCharacter() {
        when(characterMapper.toEntity(any(CharacterDTO.class))).thenReturn(character);
        when(characterRepository.save(any(Character.class))).thenReturn(character);
        when(characterMapper.toDto(any(Character.class))).thenReturn(characterDTO);

        CharacterDTO savedCharacterDTO = characterService.createCharacter(characterDTO);

        assertNotNull(savedCharacterDTO);
        assertEquals("Test Character", savedCharacterDTO.getName());
        verify(characterRepository, times(1)).save(any(Character.class));
    }

    @Test
    public void testUpdateCharacter() {
        when(characterRepository.findById(characterDTO.getId())).thenReturn(Optional.of(character));
        when(characterRepository.save(any(Character.class))).thenReturn(character);
        when(characterMapper.toDto(any(Character.class))).thenReturn(characterDTO);

        CharacterDTO updatedCharacterDTO = characterService.updateCharacter(characterDTO.getId(), characterDTO);

        assertNotNull(updatedCharacterDTO);
        assertEquals("Test Character", updatedCharacterDTO.getName());
        verify(characterRepository, times(1)).save(any(Character.class));
    }

    @Test
    public void testGetCharacter() {
        when(characterRepository.findById(characterDTO.getId())).thenReturn(Optional.of(character));
        when(characterMapper.toDto(any(Character.class))).thenReturn(characterDTO);

        CharacterDTO foundCharacterDTO = characterService.getCharacterById(characterDTO.getId());

        assertNotNull(foundCharacterDTO);
        assertEquals("Test Character", foundCharacterDTO.getName());
    }

    @Test
    public void testGetCharacterNotFound() {
        when(characterRepository.findById(characterDTO.getId())).thenReturn(Optional.empty());
        assertThrows(CharacterNotFoundException.class, () -> characterService.getCharacterById(characterDTO.getId()));
        verify(characterRepository, times(1)).findById(characterDTO.getId());
    }

    @Test
    public void testGetAllCharacters() {
        List<Character> characters = new ArrayList<>();
        characters.add(character);
        characters.add(character);
        when(characterRepository.findAll()).thenReturn(characters);

        List<CharacterDTO> charactersDTO = characterService.getAllCharacters();

        assertEquals(2, charactersDTO.size());
        verify(characterRepository, times(1)).findAll();
    }
    @Test
    public void testDeleteCharacter() {
        when(characterRepository.findById(characterDTO.getId())).thenReturn(Optional.of(character));
        characterService.deleteCharacter(characterDTO.getId());

        verify(characterRepository, times(1)).deleteById(characterDTO.getId());
    }

    @Test void testDeleteCharacterNotFound() {
        when(characterRepository.findById(characterDTO.getId())).thenReturn(Optional.empty());
        assertThrows(CharacterNotFoundException.class, () -> characterService.deleteCharacter(characterDTO.getId()));
        verify(characterRepository, times(0)).deleteById(characterDTO.getId());
    }

}
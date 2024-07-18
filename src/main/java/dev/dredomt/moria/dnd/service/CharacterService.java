package dev.dredomt.moria.dnd.service;

import dev.dredomt.moria.dnd.Exceptions.CharacterNotFoundException;
import dev.dredomt.moria.dnd.dto.CharacterDTO;
import dev.dredomt.moria.dnd.dto.CharacterMapper;
import dev.dredomt.moria.dnd.model.Character;
import dev.dredomt.moria.dnd.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterMapper characterMapper;

    public List<CharacterDTO> getAllCharacters() {
        List<Character> characters = characterRepository.findAll();
        return characters.stream()
                .map(characterMapper::toDto)
                .collect(Collectors.toList());
    }


    public CharacterDTO getCharacterById(Integer id) {
        Character character = characterRepository.findById(id)
                .orElseThrow(CharacterNotFoundException::new);
        return characterMapper.toDto(character);
    }

    public CharacterDTO createCharacter(CharacterDTO characterDTO) {
        Character character = characterMapper.toEntity(characterDTO);
        character = characterRepository.save(character);
        return characterMapper.toDto(character);
    }

    public CharacterDTO updateCharacter(Integer id, CharacterDTO characterDTO) {
        Character existingCharacter = characterRepository.findById(id)
                .orElseThrow(CharacterNotFoundException::new);
        existingCharacter.setName(characterDTO.getName());
        existingCharacter.setRace(characterDTO.getRace());
        existingCharacter.setCharacterClass(characterDTO.getCharacterClass());
        existingCharacter.setCharacterLevel(characterDTO.getCharacterLevel());

        Character updatedCharacter = characterRepository.save(existingCharacter);
        return characterMapper.toDto(updatedCharacter);
    }

    public void deleteCharacter(Integer id) {
        if (!characterRepository.existsById(id)) {
            throw new CharacterNotFoundException();
        }
        characterRepository.deleteById(id);
    }
}


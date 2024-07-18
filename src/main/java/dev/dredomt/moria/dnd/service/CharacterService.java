package dev.dredomt.moria.dnd.service;

import dev.dredomt.moria.dnd.Exceptions.CharacterNotFoundException;
import dev.dredomt.moria.dnd.model.Character;
import dev.dredomt.moria.dnd.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> getAllCharacters() {
        return (characterRepository.findAll());
    }

    public Character getCharacterById(Integer id) {
        Optional<Character> character = characterRepository.findById(id);
        if(character.isEmpty()) {
            throw new CharacterNotFoundException();
        }
        return character.get();
    }

    public Character saveCharacter(Character character) {
        return characterRepository.save(character);
    }

    public void deleteCharacter(Integer id) {
        characterRepository.deleteById(id);
    }
}

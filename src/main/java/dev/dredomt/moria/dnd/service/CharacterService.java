package dev.dredomt.moria.dnd.service;

import dev.dredomt.moria.dnd.model.Character;
import dev.dredomt.moria.dnd.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public Character getCharacterById(Integer id) {
        return characterRepository.findById(id).orElse(null);
    }

    public Character saveCharacter(Character character) {
        return characterRepository.save(character);
    }

    public void deleteCharacter(Integer id) {
        characterRepository.deleteById(id);
    }
}

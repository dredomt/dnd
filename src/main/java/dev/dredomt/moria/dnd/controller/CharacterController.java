package dev.dredomt.moria.dnd.controller;

import dev.dredomt.moria.dnd.model.Character;
import dev.dredomt.moria.dnd.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Integer id) {
        return characterService.getCharacterById(id);
    }

    @PostMapping
    public Character createCharacter(@RequestBody Character character) {
        return characterService.saveCharacter(character);
    }

    @PutMapping("/{id}")
    public Character updateCharacter(@PathVariable Integer id, @RequestBody Character character) {
        character.setId(id);
        return characterService.saveCharacter(character);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Integer id) {
        characterService.deleteCharacter(id);
    }
}

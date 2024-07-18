package dev.dredomt.moria.dnd.controller;

import dev.dredomt.moria.dnd.model.Character;
import dev.dredomt.moria.dnd.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/dnd/characters")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("")
    public List<Character> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable Integer id) {
        return characterService.getCharacterById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Character createCharacter(@Validated @RequestBody Character character) {
        return characterService.saveCharacter(character);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Character updateCharacter(@Validated @RequestBody Character character, @PathVariable Integer id) {
        character.setId(id);
        return characterService.saveCharacter(character);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Integer id) {
        characterService.deleteCharacter(id);
    }
}

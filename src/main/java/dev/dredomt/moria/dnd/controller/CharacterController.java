package dev.dredomt.moria.dnd.controller;

import dev.dredomt.moria.dnd.dto.CharacterDTO;
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

    @GetMapping
    public List<CharacterDTO> getAllCharacters() {
        return characterService.getAllCharacters();
    }

    @GetMapping("/{id}")
    public CharacterDTO getCharacterById(@PathVariable Integer id) {
        return characterService.getCharacterById(id);
    }

    @PostMapping
    public CharacterDTO createCharacter(@RequestBody CharacterDTO characterDTO) {
        return characterService.createCharacter(characterDTO);
    }

    @PutMapping("/{id}")
    public CharacterDTO updateCharacter(@PathVariable Integer id, @RequestBody CharacterDTO characterDTO) {
        return characterService.updateCharacter(id, characterDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Integer id) {
        characterService.deleteCharacter(id);
    }
}

package dev.dredomt.moria.dnd.repository;

import dev.dredomt.moria.dnd.model.Character;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends ListCrudRepository<Character, Integer> {
}
package dev.dredomt.moria.dnd.repository;

import dev.dredomt.moria.dnd.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
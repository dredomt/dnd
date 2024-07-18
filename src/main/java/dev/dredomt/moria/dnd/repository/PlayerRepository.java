package dev.dredomt.moria.dnd.repository;

import dev.dredomt.moria.dnd.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}

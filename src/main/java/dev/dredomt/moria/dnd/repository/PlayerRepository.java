package dev.dredomt.moria.dnd.repository;

import dev.dredomt.moria.dnd.model.Player;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends ListCrudRepository<Player, Integer> {
}

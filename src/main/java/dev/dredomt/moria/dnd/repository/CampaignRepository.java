package dev.dredomt.moria.dnd.repository;
import dev.dredomt.moria.dnd.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
}
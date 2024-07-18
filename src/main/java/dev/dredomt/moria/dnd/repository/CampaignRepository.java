package dev.dredomt.moria.dnd.repository;

import dev.dredomt.moria.dnd.model.Campaign;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends ListCrudRepository<Campaign, Integer> {
}
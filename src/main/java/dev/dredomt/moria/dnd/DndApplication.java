package dev.dredomt.moria.dnd;

import dev.dredomt.moria.dnd.model.Campaign;
import dev.dredomt.moria.dnd.model.Character;
import dev.dredomt.moria.dnd.model.Player;
import dev.dredomt.moria.dnd.repository.CampaignRepository;
import dev.dredomt.moria.dnd.repository.CharacterRepository;
import dev.dredomt.moria.dnd.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DndApplication implements CommandLineRunner {

	private final PlayerRepository playerRepository;
	private final CharacterRepository characterRepository;
	private final CampaignRepository campaignRepository;

    public DndApplication(PlayerRepository playerRepository, CharacterRepository characterRepository, CampaignRepository campaignRepository) {
        this.playerRepository = playerRepository;
        this.characterRepository = characterRepository;
        this.campaignRepository = campaignRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(DndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> players = playerRepository.findAll().stream().map(Player::getName).toList();
		System.out.println(players);
		List<String> characters = characterRepository.findAll().stream().map(Character::getName).toList();
		System.out.println(characters);
		List<String> campaigns = campaignRepository.findAll().stream().map(Campaign::getName).toList();
		System.out.println(campaigns);

		}
	}



package dev.dredomt.moria.dnd;

import dev.dredomt.moria.dnd.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DndApplication implements CommandLineRunner {

	private final PlayerRepository playerRepository;

    public DndApplication(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(DndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		playerRepository.findAll();
	}
}

package dev.dredomt.moria.dnd.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String username;
    private String experience;

    @OneToMany(mappedBy = "player")
    private List<Character> characters = new ArrayList<>();
}

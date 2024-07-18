package dev.dredomt.moria.dnd.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;

    @OneToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;
}

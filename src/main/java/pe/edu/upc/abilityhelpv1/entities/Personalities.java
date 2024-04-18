package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Personality")
public class Personalities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_personality;
    @Column(name = "name_personality", nullable = false, length = 35)
    private String name_personality;
    @Column(name = "description", nullable = false, length = 35)
    private String description;

    public Personalities(int id_personality, String name_personality, String description) {
        this.id_personality = id_personality;
        this.name_personality = name_personality;
        this.description = description;
    }

    public Personalities() {

    }

    public int getId_personality() {
        return id_personality;
    }

    public void setId_personality(int id_personality) {
        this.id_personality = id_personality;
    }

    public String getName_personality() {
        return name_personality;
    }

    public void setName_personality(String name_personality) {
        this.name_personality = name_personality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

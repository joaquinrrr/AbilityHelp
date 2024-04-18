package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Personality")
public class Personalities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonality;
    @Column(name = "namePersonality", nullable = false, length = 35)
    private String namePersonality;
    @Column(name = "description", nullable = false, length = 35)
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    public Personalities() {
    }

    public Personalities(int idPersonality, String namePersonality, String description, User user) {
        this.idPersonality = idPersonality;
        this.namePersonality = namePersonality;
        this.description = description;
        this.user = user;
    }

    public int getIdPersonality() {
        return idPersonality;
    }

    public void setIdPersonality(int idPersonality) {
        this.idPersonality = idPersonality;
    }

    public String getNamePersonality() {
        return namePersonality;
    }

    public void setNamePersonality(String namePersonality) {
        this.namePersonality = namePersonality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

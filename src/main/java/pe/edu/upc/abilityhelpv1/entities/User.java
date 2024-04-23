package pe.edu.upc.abilityhelpv1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import javax.management.relation.Role;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "UserTable")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(name = "username", nullable = false, length = 35)
    private String username;
    @Column(name = "email", nullable = false, length = 35)
    private String emailUser;
    @Column(name = "password", nullable = false, length = 200)
    private String password;
    @Column(name = "age", nullable = false, length = 2)
    private int ageUser;
    private Boolean enabled;
    // En User.java
    @ManyToOne
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "personality_id", nullable = false)
    private Personalities personality;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    @JsonIgnore
    private List<Rol> rol;

    public User() {
    }

    public User(Long idUser, String username, String emailUser, String password, int ageUser, Boolean enabled, Gender gender, Personalities personality, List<Rol> rol) {
        this.idUser = idUser;
        this.username = username;
        this.emailUser = emailUser;
        this.password = password;
        this.ageUser = ageUser;
        this.enabled = enabled;
        this.gender = gender;
        this.personality = personality;
        this.rol = rol;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(int ageUser) {
        this.ageUser = ageUser;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Personalities getPersonality() {
        return personality;
    }

    public void setPersonality(Personalities personality) {
        this.personality = personality;
    }

    public List<Rol> getRol() {
        return rol;
    }

    public void setRol(List<Rol> rol) {
        this.rol = rol;
    }
}

package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGender;

    @Column(name = "nameGender", nullable = false, length = 10)
    private String nameGender;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Gender() {
    }

    public Gender(int idGender, String nameGender, User user) {
        this.idGender = idGender;
        this.nameGender = nameGender;
        this.user = user;
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public String getNameGender() {
        return nameGender;
    }

    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

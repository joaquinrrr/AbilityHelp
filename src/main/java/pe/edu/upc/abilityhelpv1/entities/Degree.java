package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Degree")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrera;

    @Column(name = "nameDegree", nullable = false, length = 35)
    private String nameDegree;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    public Degree() {
    }

    public Degree(int idCarrera, String nameDegree, User user) {
        this.idCarrera = idCarrera;
        this.nameDegree = nameDegree;
        this.user = user;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNameDegree() {
        return nameDegree;
    }

    public void setNameDegree(String nameDegree) {
        this.nameDegree = nameDegree;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

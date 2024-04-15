package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "User-help")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(name = "nameUser", nullable = false, length = 35)
    private String nameUser;
    @Column(name = "emailUser", nullable = false, length = 35)
    private String emailUser;
    @Column(name = "passwordUser", nullable = false, length = 35)
    private String passwordUser;
    @Column(name = "ageUser", nullable = false, length = 2)
    private int ageUser;
    @ManyToOne
    @JoinColumn(name = "rolid")
    private Rol rol;
    @ManyToOne
    @JoinColumn(name = "degreeid")
    private Degree degree;

    public User() {
    }

    public User(int idUser, String nameUser, String emailUser, String passwordUser, int ageUser, Rol rol, Degree degree) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.ageUser = ageUser;
        this.rol = rol;
        this.degree = degree;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public int getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(int ageUser) {
        this.ageUser = ageUser;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }
}

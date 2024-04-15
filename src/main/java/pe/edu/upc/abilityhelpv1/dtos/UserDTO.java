package pe.edu.upc.abilityhelpv1.dtos;

import jakarta.persistence.*;
import pe.edu.upc.abilityhelpv1.entities.Degree;
import pe.edu.upc.abilityhelpv1.entities.Rol;

public class UserDTO {

    private int idUser;
    private String nameUser;
    private String emailUser;
    private String passwordUser;
    private int ageUser;
    private Rol rol;
    private Degree degree;

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

    public Rol get() {
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

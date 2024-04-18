package pe.edu.upc.abilityhelpv1.dtos;

import jakarta.persistence.*;
import pe.edu.upc.abilityhelpv1.entities.Degree;
import pe.edu.upc.abilityhelpv1.entities.Gender;
import pe.edu.upc.abilityhelpv1.entities.Personalities;
import pe.edu.upc.abilityhelpv1.entities.Rol;

import java.util.List;

public class UserDTO {
    private int idUser;
    private String username;
    private String emailUser;
    private String password;
    private int ageUser;
    private Boolean enabled;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
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
}

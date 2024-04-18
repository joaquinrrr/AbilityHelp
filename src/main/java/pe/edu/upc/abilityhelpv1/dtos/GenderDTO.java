package pe.edu.upc.abilityhelpv1.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import pe.edu.upc.abilityhelpv1.entities.User;

public class GenderDTO {
    private int idGender;
    private String nameGender;
    private User user;

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

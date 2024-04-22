package pe.edu.upc.abilityhelpv1.dtos;

import jakarta.persistence.*;
import pe.edu.upc.abilityhelpv1.entities.TypeInteraction;
import pe.edu.upc.abilityhelpv1.entities.User;

import java.time.LocalDate;

public class InteractionDTO {
    private int id;
    private LocalDate date;
    private User userSender;
    private User userReceiver;
    private TypeInteraction idType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public User getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(User userReceiver) {
        this.userReceiver = userReceiver;
    }

    public TypeInteraction getIdType() {
        return idType;
    }

    public void setIdType(TypeInteraction idType) {
        this.idType = idType;
    }
}

package pe.edu.upc.abilityhelpv1.dtos;

import jakarta.persistence.*;
import pe.edu.upc.abilityhelpv1.entities.TypeInteraction;
import pe.edu.upc.abilityhelpv1.entities.User;

import java.time.LocalDate;

public class InteractionDTO {
    private int id;
    private LocalDate date;
    private User StudentSender;
    private User StudentReceiver;
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

    public User getStudentSender() {
        return StudentSender;
    }

    public void setStudentSender(User studentSender) {
        StudentSender = studentSender;
    }

    public User getStudentReceiver() {
        return StudentReceiver;
    }

    public void setStudentReceiver(User studentReceiver) {
        StudentReceiver = studentReceiver;
    }

    public TypeInteraction getIdType() {
        return idType;
    }

    public void setIdType(TypeInteraction idType) {
        this.idType = idType;
    }
}

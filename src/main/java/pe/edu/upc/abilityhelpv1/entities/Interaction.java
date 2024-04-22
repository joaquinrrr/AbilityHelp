package pe.edu.upc.abilityhelpv1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Interaction")
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dateInteraction", nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id_Sender", nullable = false)
    private User userSender;
    @ManyToOne
    @JoinColumn(name = "user_id_Receiver", nullable = false)
    private User userReceiver;

    @ManyToOne
    @JoinColumn(name = "interaction_id", nullable = false)
    private TypeInteraction idType;

    public Interaction() {
    }

    public Interaction(int id, LocalDate date, User userSender, User userReceiver, TypeInteraction idType) {
        this.id = id;
        this.date = date;
        this.userSender = userSender;
        this.userReceiver = userReceiver;
        this.idType = idType;
    }

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

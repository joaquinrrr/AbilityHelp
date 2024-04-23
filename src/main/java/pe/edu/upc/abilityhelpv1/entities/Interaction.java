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
    @JoinColumn(name = "Student_id_Sender", nullable = false)
    private User studentSender;
    @ManyToOne
    @JoinColumn(name = "Student_id_Receiver", nullable = false)
    private User studentReceiver;

    @ManyToOne
    @JoinColumn(name = "interaction_id", nullable = false)
    private TypeInteraction idType;

    public Interaction() {
    }

    public Interaction(int id, LocalDate date, User studentSender, User studentReceiver, TypeInteraction idType) {
        this.id = id;
        this.date = date;
        this.studentSender = studentSender;
        this.studentReceiver = studentReceiver;
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

    public User getStudentSender() {
        return studentSender;
    }

    public void setStudentSender(User studentSender) {
        this.studentSender = studentSender;
    }

    public User getStudentReceiver() {
        return studentReceiver;
    }

    public void setStudentReceiver(User studentReceiver) {
        this.studentReceiver = studentReceiver;
    }

    public TypeInteraction getIdType() {
        return idType;
    }

    public void setIdType(TypeInteraction idType) {
        this.idType = idType;
    }
}

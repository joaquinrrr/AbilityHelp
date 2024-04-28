package pe.edu.upc.abilityhelpv1.entities;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChat;
    @Column(name = "message", nullable = false, length = 35)
    private String message;
    @Column(name = "dateSend", nullable = false, length = 35)
    private LocalDateTime dateSend;
    @ManyToOne
    @JoinColumn(name = "idStudentSender", nullable = false)
    private Users idStudentSender;
    @ManyToOne
    @JoinColumn(name = "idStudentRecipient", nullable = false)
    private Users idStudentRecipient;

    public Chat(int idChat, String message, LocalDateTime dateSend, Users idStudentSender, Users idStudentRecipient) {
        this.idChat = idChat;
        this.message = message;
        this.dateSend = dateSend;
        this.idStudentSender = idStudentSender;
        this.idStudentRecipient = idStudentRecipient;
    }

    public Chat() {

    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateSend() {
        return dateSend;
    }

    public void setDateSend(LocalDateTime dateSend) {
        this.dateSend = dateSend;
    }

    public Users getIdStudentSender() {
        return idStudentSender;
    }

    public void setIdStudentSender(Users idStudentSender) {
        this.idStudentSender = idStudentSender;
    }

    public Users getIdStudentRecipient() {
        return idStudentRecipient;
    }

    public void setIdStudentRecipient(Users idStudentRecipient) {
        this.idStudentRecipient = idStudentRecipient;
    }
}

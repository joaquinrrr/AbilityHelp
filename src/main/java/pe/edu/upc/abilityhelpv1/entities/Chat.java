package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChat;
    @Column(name = "message", nullable = false, length = 35)
    private String message;
    @Column(name = "dateSend", nullable = false, length = 35)
    private LocalDateTime dateSend;
    @ManyToOne
    @JoinColumn(name = "idUserSender", nullable = false)
    private User idUserSender;
    @ManyToOne
    @JoinColumn(name = "idUserRecipient", nullable = false)
    private User idUserRecipient;


    public Chat() {
    }

    public Chat(int idChat, String message, LocalDateTime dateSend, User idUserSender, User idUserRecipient) {
        this.idChat = idChat;
        this.message = message;
        this.dateSend = dateSend;
        this.idUserSender = idUserSender;
        this.idUserRecipient = idUserRecipient;
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

    public User getIdUserSender() {
        return idUserSender;
    }

    public void setIdUserSender(User idUserSender) {
        this.idUserSender = idUserSender;
    }

    public User getIdUserRecipient() {
        return idUserRecipient;
    }

    public void setIdUserRecipient(User idUserRecipient) {
        this.idUserRecipient = idUserRecipient;
    }
}

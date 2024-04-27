package pe.edu.upc.abilityhelpv1.dtos;

import jakarta.persistence.*;
import pe.edu.upc.abilityhelpv1.entities.User;

import java.time.LocalDateTime;

public class ChatDTO {
    private int idChat;
    private String message;
    private LocalDateTime dateSend;
    private User idStudentSender;
    private User idStudentRecipient;

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

    public User getIdStudentSender() {
        return idStudentSender;
    }

    public void setIdStudentSender(User idStudentSender) {
        this.idStudentSender = idStudentSender;
    }

    public User getIdStudentRecipient() {
        return idStudentRecipient;
    }

    public void setIdStudentRecipient(User idStudentRecipient) {
        this.idStudentRecipient = idStudentRecipient;
    }
}

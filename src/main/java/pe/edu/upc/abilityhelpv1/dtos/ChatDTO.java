package pe.edu.upc.abilityhelpv1.dtos;

import pe.edu.upc.abilityhelpv1.entities.Users;

import java.time.LocalDateTime;

public class ChatDTO {
    private int idChat;
    private String message;
    private LocalDateTime dateSend;
    private Users idStudentSender;
    private Users idStudentRecipient;

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

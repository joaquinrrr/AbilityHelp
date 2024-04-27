package pe.edu.upc.abilityhelpv1.dtos;

import java.time.LocalDate;

public class MeetingPerCoachDTO {
    private String coach;
    private LocalDate date;
    private int quantity;

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

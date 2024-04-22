package pe.edu.upc.abilityhelpv1.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MeetingPerUserDateDTO {
    private String nameU;
    private LocalDate date;
    private LocalDateTime starthour;
    private LocalDateTime finishhour;

    public String getNameU() {
        return nameU;
    }

    public void setNameU(String nameU) {
        this.nameU = nameU;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getStarthour() {
        return starthour;
    }

    public void setStarthour(LocalDateTime starthour) {
        this.starthour = starthour;
    }

    public LocalDateTime getFinishhour() {
        return finishhour;
    }

    public void setFinishhour(LocalDateTime finishhour) {
        this.finishhour = finishhour;
    }
}

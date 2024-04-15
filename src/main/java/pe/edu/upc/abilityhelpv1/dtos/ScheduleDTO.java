package pe.edu.upc.abilityhelpv1.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import pe.edu.upc.abilityhelpv1.entities.User;

import java.time.LocalTime;
import java.time.LocalDate;


public class ScheduleDTO {
    private int idSchedule;
    private LocalDate  weekDay;
    private LocalTime  startHour;
    private LocalTime finishHour;
    private User coachUser;

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public LocalDate getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(LocalDate weekDay) {
        this.weekDay = weekDay;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public LocalTime getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(LocalTime finishHour) {
        this.finishHour = finishHour;
    }

    public User getCoachUser() {
        return coachUser;
    }

    public void setCoachUser(User coachUser) {
        this.coachUser = coachUser;
    }
}

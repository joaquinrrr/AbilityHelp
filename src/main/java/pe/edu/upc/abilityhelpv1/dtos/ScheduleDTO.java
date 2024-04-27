package pe.edu.upc.abilityhelpv1.dtos;


import pe.edu.upc.abilityhelpv1.entities.User;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;


public class ScheduleDTO {
    private int idSchedule;
    private LocalDate  weekDay;
    private LocalDateTime startHour;
    private LocalDateTime finishHour;
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

    public LocalDateTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalDateTime startHour) {
        this.startHour = startHour;
    }

    public LocalDateTime getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(LocalDateTime finishHour) {
        this.finishHour = finishHour;
    }

    public User getCoachUser() {
        return coachUser;
    }

    public void setCoachUser(User coachUser) {
        this.coachUser = coachUser;
    }
}

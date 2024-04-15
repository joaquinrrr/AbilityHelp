package pe.edu.upc.abilityhelpv1.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.time.LocalDate;

@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSchedule;

    @Column(name = "weekDay", nullable = false) //NO PONER GUIONES AL MOMENTO DE HACER EL TRABAJO
    private LocalDate  weekDay;

    @Column(name = "startHour", nullable = false)
    private LocalTime startHour;

    @Column(name = "finishHour", nullable = false)
    private LocalTime finishHour;

    @ManyToOne
    @JoinColumn(name="coachId")
    private User userCoach;

    public Schedule(){

    }

    public Schedule(int idSchedule, LocalDate weekDay, LocalTime startHour, LocalTime finishHour, User userCoach) {
        this.idSchedule = idSchedule;
        this.weekDay = weekDay;
        this.startHour = startHour;
        this.finishHour = finishHour;
        this.userCoach = userCoach;
    }

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

    public User getUserCoach() {
        return userCoach;
    }

    public void setUserCoach(User userCoach) {
        this.userCoach = userCoach;
    }
}

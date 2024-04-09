package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSchedule;

    @Column(name = "weekDay", nullable = false) //NO PONER GUIONES AL MOMENTO DE HACER EL TRABAJO
    private LocalDate  weekDay;

    @Column(name = "startHour", nullable = false)
    private Time startHour;

    @Column(name = "finishHour", nullable = false)
    private Time finishHour;

    public Schedule(){

    }

    public Schedule(int idSchedule, LocalDate weekDay, Time startHour, Time finishHour) {
        this.idSchedule = idSchedule;
        this.weekDay = weekDay;
        this.startHour = startHour;
        this.finishHour = finishHour;
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

    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    public Time getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(Time finishHour) {
        this.finishHour = finishHour;
    }
}

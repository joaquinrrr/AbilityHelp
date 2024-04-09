package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_schedule;

    @Column(name = "week_day", nullable = false)
    private LocalDate  week_day;

    @Column(name = "start_hour", nullable = false)
    private LocalDateTime start_hour;

    @Column(name = "finish_hour", nullable = false)
    private LocalDateTime finish_hour;

    public Schedule(){

    }

    public Schedule(int id_schedule, LocalDate  week_day, LocalDateTime start_hour, LocalDateTime finish_hour) {
        this.id_schedule = id_schedule;
        this.week_day = week_day;
        this.start_hour = start_hour;
        this.finish_hour = finish_hour;
    }

    public int getId_schedule() {
        return id_schedule;
    }

    public void setId_schedule(int id_schedule) {
        this.id_schedule = id_schedule;
    }

    public LocalDate  getWeek_day() {
        return week_day;
    }

    public void setWeek_day(LocalDate  week_day) {
        this.week_day = week_day;
    }

    public LocalDateTime getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(LocalDateTime start_hour) {
        this.start_hour = start_hour;
    }

    public LocalDateTime getFinish_hour() {
        return finish_hour;
    }

    public void setFinish_hour(LocalDateTime finish_hour) {
        this.finish_hour = finish_hour;
    }
}

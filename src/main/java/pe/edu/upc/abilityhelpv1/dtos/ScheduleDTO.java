package pe.edu.upc.abilityhelpv1.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ScheduleDTO {
    private int id_schedule;
    private LocalDate week_day;
    private LocalDateTime start_hour;
    private LocalDateTime finish_hour;

    public int getId_schedule() {
        return id_schedule;
    }

    public void setId_schedule(int id_schedule) {
        this.id_schedule = id_schedule;
    }

    public LocalDate getWeek_day() {
        return week_day;
    }

    public void setWeek_day(LocalDate week_day) {
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

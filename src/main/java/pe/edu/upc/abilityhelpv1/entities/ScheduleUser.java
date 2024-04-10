package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ScheduleUser")
public class ScheduleUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserSchedule;

    @ManyToOne
    @JoinColumn(name="userId")
    private User idUser;

    @ManyToOne
    @JoinColumn(name="scheduleId")
    private Schedule idSchedule;

    public ScheduleUser() {
    }

    public ScheduleUser(int idUserSchedule, User idUser, Schedule idSchedule) {
        this.idUserSchedule = idUserSchedule;
        this.idUser = idUser;
        this.idSchedule = idSchedule;
    }

    public int getIdUserSchedule() {
        return idUserSchedule;
    }

    public void setIdUserSchedule(int idUserSchedule) {
        this.idUserSchedule = idUserSchedule;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Schedule getiSchedule() {
        return idSchedule;
    }

    public void setiSchedule(Schedule idSchedule) {
        this.idSchedule = idSchedule;
    }

    
}

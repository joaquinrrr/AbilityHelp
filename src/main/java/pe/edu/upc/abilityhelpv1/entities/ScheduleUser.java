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
    private Schedule iSchedule;

    public ScheduleUser() {
    }

    public ScheduleUser(int idUserSchedule, User idUser, Schedule iSchedule) {
        this.idUserSchedule = idUserSchedule;
        this.idUser = idUser;
        this.iSchedule = iSchedule;
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
        return iSchedule;
    }

    public void setiSchedule(Schedule iSchedule) {
        this.iSchedule = iSchedule;
    }

    
}

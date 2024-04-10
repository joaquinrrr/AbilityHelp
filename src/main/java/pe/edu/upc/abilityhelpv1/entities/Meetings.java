package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Meetings")
public class Meetings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMeet;

    @ManyToOne
    @JoinColumn(name = "userIdschedule")
    private User idUserSchedule;

    @ManyToOne
    @JoinColumn(name = "coachId")
    private User idCoach;

    public Meetings(){
        
    }

    public Meetings(int idMeet, User idUserSchedule, User idCoach) {
        this.idMeet = idMeet;
        this.idUserSchedule = idUserSchedule;
        this.idCoach = idCoach;
    }

    public int getIdMeet() {
        return idMeet;
    }

    public void setIdMeet(int idMeet) {
        this.idMeet = idMeet;
    }

    public User getIdUserSchedule() {
        return idUserSchedule;
    }

    public void setIdUserSchedule(User idUserSchedule) {
        this.idUserSchedule = idUserSchedule;
    }

    public User getIdCoach() {
        return idCoach;
    }

    public void setIdCoach(User idCoach) {
        this.idCoach = idCoach;
    }

}

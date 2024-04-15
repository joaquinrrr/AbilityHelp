package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;
import pe.edu.upc.abilityhelpv1.entities.User;

@Entity
@Table(name = "Meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMeet;
    @ManyToOne
    @JoinColumn(name="userId")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "idSchedule")
    private Schedule idmeetSchedule;

    public Meeting() {
    }

    public Meeting(int idMeet, User userId, Schedule idmeetSchedule) {
        this.idMeet = idMeet;
        this.userId = userId;
        this.idmeetSchedule = idmeetSchedule;
    }

    public int getIdMeet() {
        return idMeet;
    }

    public void setIdMeet(int idMeet) {
        this.idMeet = idMeet;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Schedule getIdmeetSchedule() {
        return idmeetSchedule;
    }

    public void setIdmeetSchedule(Schedule idmeetSchedule) {
        this.idmeetSchedule = idmeetSchedule;
    }
}

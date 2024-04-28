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
    @JoinColumn(name="studentId")
    private User studentId;

    @ManyToOne
    @JoinColumn(name = "idSchedule")
    private Schedule idmeetSchedule;

    public Meeting() {
    }

    public Meeting(int idMeet, User studentId, Schedule idmeetSchedule) {
        this.idMeet = idMeet;
        this.studentId = studentId;
        this.idmeetSchedule = idmeetSchedule;
    }

    public int getIdMeet() {
        return idMeet;
    }

    public void setIdMeet(int idMeet) {
        this.idMeet = idMeet;
    }

    public User getStudentId() {
        return studentId;
    }

    public void setStudentId(User studentId) {
        this.studentId = studentId;
    }

    public Schedule getIdmeetSchedule() {
        return idmeetSchedule;
    }

    public void setIdmeetSchedule(Schedule idmeetSchedule) {
        this.idmeetSchedule = idmeetSchedule;
    }
}
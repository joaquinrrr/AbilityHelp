package pe.edu.upc.abilityhelpv1.dtos;

import jakarta.persistence.*;
import pe.edu.upc.abilityhelpv1.entities.Schedule;
import pe.edu.upc.abilityhelpv1.entities.User;

public class MeetingDTO {
    private int idMeet;
    private User studentId;
    private Schedule idmeetSchedule;

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

package pe.edu.upc.abilityhelpv1.dtos;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import pe.edu.upc.abilityhelpv1.entities.Schedule;

public class ScheduleUserDTO {
    private int idUserSchedule;
    private User idUser;
    private Schedule idSchedule;
    
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
    public Schedule getIdSchedule() {
        return idSchedule;
    }
    public void setIdSchedule(Schedule idSchedule) {
        this.idSchedule = idSchedule;
    }

    
}

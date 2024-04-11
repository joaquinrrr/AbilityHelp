package pe.edu.upc.abilityhelpv1.dtos;

public class ScheduleUserDTO {
    private int idUserSchedule;
    private int idUser;
    private int idSchedule;

    public ScheduleUserDTO() {
    }

    public ScheduleUserDTO(int idUserSchedule, int idUser, int idSchedule) {
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

}

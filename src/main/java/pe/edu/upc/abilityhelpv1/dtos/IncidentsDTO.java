package pe.edu.upc.abilityhelpv1.dtos;

import java.time.LocalDate;
import java.util.Date;

public class IncidentsDTO {
    private int id_incident;
    private String type_incident;
    private String description;
    private Date date_incident;

    public int getId_incident() {
        return id_incident;
    }

    public void setId_incident(int id_incident) {
        this.id_incident = id_incident;
    }

    public String getType_incident() {
        return type_incident;
    }

    public void setType_incident(String type_incident) {
        this.type_incident = type_incident;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_incident() {
        return date_incident;
    }

    public void setDate_incident(Date date_incident) {
        this.date_incident = date_incident;
    }
}

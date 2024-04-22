package pe.edu.upc.abilityhelpv1.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.entities.User;

import java.time.LocalDate;

public class AssignIncidentDTO {
    private int id;
    private String status;
    private LocalDate dateAssign;
    private String detailIncident;

    private User idAdmin;
    private User idUserReporter;
    private User idUserBan;

    private Incidents incidents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateAssign() {
        return dateAssign;
    }

    public void setDateAssign(LocalDate dateAssign) {
        this.dateAssign = dateAssign;
    }

    public String getDetailIncident() {
        return detailIncident;
    }

    public void setDetailIncident(String detailIncident) {
        this.detailIncident = detailIncident;
    }

    public User getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(User idAdmin) {
        this.idAdmin = idAdmin;
    }

    public User getIdUserReporter() {
        return idUserReporter;
    }

    public void setIdUserReporter(User idUserReporter) {
        this.idUserReporter = idUserReporter;
    }

    public User getIdUserBan() {
        return idUserBan;
    }

    public void setIdUserBan(User idUserBan) {
        this.idUserBan = idUserBan;
    }

    public Incidents getIncidents() {
        return incidents;
    }

    public void setIncidents(Incidents incidents) {
        this.incidents = incidents;
    }
}

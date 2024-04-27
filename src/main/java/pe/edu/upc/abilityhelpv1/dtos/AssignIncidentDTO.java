package pe.edu.upc.abilityhelpv1.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.entities.Users;

import java.time.LocalDate;

public class AssignIncidentDTO {
    private int id;
    private String status;
    private LocalDate dateAssign;
    private String detailIncident;
    private Users idAdmin;
    private Users idStudentReporter;
    private Users idStudentBan;
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

    public Users getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Users idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Users getIdStudentReporter() {
        return idStudentReporter;
    }

    public void setIdStudentReporter(Users idStudentReporter) {
        this.idStudentReporter = idStudentReporter;
    }

    public Users getIdStudentBan() {
        return idStudentBan;
    }

    public void setIdStudentBan(Users idStudentBan) {
        this.idStudentBan = idStudentBan;
    }

    public Incidents getIncidents() {
        return incidents;
    }

    public void setIncidents(Incidents incidents) {
        this.incidents = incidents;
    }
}

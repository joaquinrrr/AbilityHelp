package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "AssignIncident")
public class AssignIncident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "status", nullable = false, length = 35)
    private String status;
    @Column(name = "dateAssign", nullable = false, length = 35)
    private LocalDate dateAssign;
    @Column(name = "detailIncident", nullable = false, length = 200)
    private String detailIncident;
    @ManyToOne
    @JoinColumn(name = "idAdmin", nullable = false)
    private User idAdmin;
    @ManyToOne
    @JoinColumn(name = "idUserReporter", nullable = false)
    private User idUserReporter;
    @ManyToOne
    @JoinColumn(name = "idUserBan", nullable = false)
    private User idUserBan;

    @ManyToOne
    @JoinColumn(name = "typeIncident", nullable = false)
    private Incidents incidents;

    public AssignIncident() {
    }

    public AssignIncident(int id, String status, LocalDate dateAssign, String detailIncident, User idAdmin, User idUserReporter, User idUserBan, Incidents incidents) {
        this.id = id;
        this.status = status;
        this.dateAssign = dateAssign;
        this.detailIncident = detailIncident;
        this.idAdmin = idAdmin;
        this.idUserReporter = idUserReporter;
        this.idUserBan = idUserBan;
        this.incidents = incidents;
    }

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

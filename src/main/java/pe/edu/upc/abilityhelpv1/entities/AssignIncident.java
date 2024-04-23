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
    @JoinColumn(name = "idStudentReporter", nullable = false)
    private User idStudentReporter;
    @ManyToOne
    @JoinColumn(name = "idStudentBan", nullable = false)
    private User idStudentBan;

    @ManyToOne
    @JoinColumn(name = "typeIncident", nullable = false)
    private Incidents incidents;

    public AssignIncident() {
    }

    public AssignIncident(int id, String status, LocalDate dateAssign, String detailIncident, User idAdmin, User idStudentReporter, User idStudentBan, Incidents incidents) {
        this.id = id;
        this.status = status;
        this.dateAssign = dateAssign;
        this.detailIncident = detailIncident;
        this.idAdmin = idAdmin;
        this.idStudentReporter = idStudentReporter;
        this.idStudentBan = idStudentBan;
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

    public User getIdStudentReporter() {
        return idStudentReporter;
    }

    public void setIdStudentReporter(User idStudentReporter) {
        this.idStudentReporter = idStudentReporter;
    }

    public User getIdStudentBan() {
        return idStudentBan;
    }

    public void setIdStudentBan(User idStudentBan) {
        this.idStudentBan = idStudentBan;
    }

    public Incidents getIncidents() {
        return incidents;
    }

    public void setIncidents(Incidents incidents) {
        this.incidents = incidents;
    }
}

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
    private Users idAdmin;
    @ManyToOne
    @JoinColumn(name = "idStudentReporter", nullable = false)
    private Users idStudentReporter;
    @ManyToOne
    @JoinColumn(name = "idStudentBan", nullable = false)
    private Users idStudentBan;

    @ManyToOne
    @JoinColumn(name = "typeIncident", nullable = false)
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

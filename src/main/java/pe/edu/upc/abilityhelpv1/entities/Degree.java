package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Carrera")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DegreeID;
    @Column(name = "nameDegree", nullable = false, length = 35)
    private String DegreeName;

    public Degree() {
    }

    public Degree(int DegreeID, String DegreeName) {
        this.DegreeID = DegreeID;
        this.DegreeName = DegreeName;
    }

    public int getDegreeID() {
        return DegreeID;
    }

    public String getDegreeName() {
        return DegreeName;
    }

    public void setDegreeID(int DegreeID) {
        this.DegreeID = DegreeID;
    }

    public void setDegreeName(String DegreeName) {
        this.DegreeName = DegreeName;
    }
}

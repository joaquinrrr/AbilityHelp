package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="Gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_gender;
    @Column(name = "name_gender", nullable = false, length = 50)
    private String name_gender;

    public Gender(){

    }
    public Gender(int id_gender, String name) {
        this.id_gender = id_gender;
        this.name_gender = name;
    }

    public int getId_gender() {
        return id_gender;
    }

    public String getName() {
        return name_gender;
    }

    public void setId_gender(int id_gender) {
        this.id_gender = id_gender;
    }

    public void setName(String name) {
        this.name_gender = name;
    }
}

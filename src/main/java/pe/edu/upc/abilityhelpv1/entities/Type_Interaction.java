package pe.edu.upc.abilityhelpv1.entities;
import jakarta.persistence.*;



@Entity
@Table(name = "Type_Interaction")
public class Type_Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type_interaction;

    @Column (name = "type_interaction",nullable = true,length = 50)
    private String type_interaction;

    public Type_Interaction(int id_type_interaction, String type_interaction){
        this.id_type_interaction=id_type_interaction;
        this.type_interaction=type_interaction;
    }

    public Type_Interaction() {

    }


    public int getId_type_interaction() {
        return id_type_interaction;
    }

    public void setId_type_interaction(int id_type_interaction) {
        this.id_type_interaction = id_type_interaction;
    }

    public String getType_interaction() {
        return type_interaction;
    }

    public void setType_interaction(String type_interaction) {
        this.type_interaction = type_interaction;
    }




}

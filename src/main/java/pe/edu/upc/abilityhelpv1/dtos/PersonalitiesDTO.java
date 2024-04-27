package pe.edu.upc.abilityhelpv1.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import pe.edu.upc.abilityhelpv1.entities.User;

public class PersonalitiesDTO {
    private int idPersonality;
    private String namePersonality;
    private String description;

    public int getIdPersonality() {
        return idPersonality;
    }

    public void setIdPersonality(int idPersonality) {
        this.idPersonality = idPersonality;
    }

    public String getNamePersonality() {
        return namePersonality;
    }

    public void setNamePersonality(String namePersonality) {
        this.namePersonality = namePersonality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

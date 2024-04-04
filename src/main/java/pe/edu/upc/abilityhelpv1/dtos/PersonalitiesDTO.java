package pe.edu.upc.abilityhelpv1.dtos;

public class PersonalitiesDTO {
    private int id_personality;
    private String name;
    private String description;

    public int getId_personality() {
        return id_personality;
    }

    public void setId_personality(int id_personality) {
        this.id_personality = id_personality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

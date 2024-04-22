package pe.edu.upc.abilityhelpv1.dtos;

public class PersonalityPerCarrerDTO {
    private String typePersonality;
    private String degree;
    private int quantity;

    public String getTypePersonality() {
        return typePersonality;
    }

    public void setTypePersonality(String typePersonality) {
        this.typePersonality = typePersonality;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

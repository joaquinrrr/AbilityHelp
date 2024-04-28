package pe.edu.upc.abilityhelpv1.dtos;

public class AssignIncidentCountDTO {
    private String TypeInci;
    private int quantity;

    public String getTypeInci() {
        return TypeInci;
    }

    public void setTypeInci(String typeInci) {
        TypeInci = typeInci;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
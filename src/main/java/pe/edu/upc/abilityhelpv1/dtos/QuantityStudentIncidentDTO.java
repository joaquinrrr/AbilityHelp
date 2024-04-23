package pe.edu.upc.abilityhelpv1.dtos;

public class QuantityStudentIncidentDTO {
    private String banned;
    private int quantity;

    public String getBanned() {
        return banned;
    }

    public void setBanned(String banned) {
        this.banned = banned;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

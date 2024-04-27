package pe.edu.upc.abilityhelpv1.dtos;

public class QuantityIncidentPerStatusDTO {
    private String nameIncident;
    private String status;
    private int quantity;

    public String getNameIncident() {
        return nameIncident;
    }

    public void setNameIncident(String nameIncident) {
        this.nameIncident = nameIncident;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

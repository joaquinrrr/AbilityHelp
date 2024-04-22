package pe.edu.upc.abilityhelpv1.dtos;

public class QuantityUserIncidentDTO {
    private String reporter;
    private int quantity;

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

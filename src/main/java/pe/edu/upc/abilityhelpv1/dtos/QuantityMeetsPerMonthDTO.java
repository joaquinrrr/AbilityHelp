package pe.edu.upc.abilityhelpv1.dtos;

public class QuantityMeetsPerMonthDTO {
    private String month;
    private int quantity;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

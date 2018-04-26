public abstract class ConsumableItem {

    private double unitPrice;

    public ConsumableItem(double price){
        this.unitPrice = price;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double price) {
        this.unitPrice = price;

    }
}

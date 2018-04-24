public abstract class ConsumableItem {

    private final double unitPrice;

    public ConsumableItem(double price){
        this.unitPrice = price;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}

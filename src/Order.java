import com.sun.org.apache.xpath.internal.operations.Or;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Order {


    /**
     * Receipt takes care of subtotal, total.
     */
    private class Receipt {
        private static final double TAX_RATE = 0.06;
        private double tipAmount = 0;
        private double subtotal = 0;

        private double getTipAmount() {
            return tipAmount;
        }

        public void setTipAmount(double tipAmount) {
            this.tipAmount = tipAmount;
        }

        private double getSubtotal() {
            return subtotal;
        }

        private void addToSubtotal(double priceToAdd) {
            this.subtotal += priceToAdd;
        }

    }

    private LinkedList<ConsumableItem> items;
    private String customerName;
    private LocalDateTime time;
    private Receipt receipt;

    public Order( String customerName ){
        this.time = LocalDateTime.now();
        this.customerName = customerName;
        items = new LinkedList<>();
        receipt = new Receipt();

    }

    public void addItem(ConsumableItem orderedItem) {
        items.add(orderedItem);
        receipt.addToSubtotal(orderedItem.getUnitPrice());
    }

    public int getOrderSize() {
        return items.size();
    }

    public ConsumableItem getItem(int index) {
        return items.get(index);
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public LocalDateTime getOrderTime() {
        return time;
    }

    public double getTaxRate() {
        return Receipt.TAX_RATE;
    }

    public double getTipAmount() {
        return this.receipt.getTipAmount();
    }

    public void setTipAmount(double tipAmount) {
        this.receipt.setTipAmount( tipAmount );
    }

    public double getSubtotal() {
        return this.receipt.getSubtotal();
    }

    public double getDiscountAmount() {
        int tacoCount = this.getTacoCount();
        if( tacoCount >= 3 ) {
            return 0.5 * tacoCount;
        }
        return 0;
    }

    private int getTacoCount() {
        int count = 0;
        for (ConsumableItem element : this.items) {
            if (element instanceof Taco) {
                count++;
            }
        }
        return count;
    }

    public double getTotal() {
        return getSubtotal() * (1+getTaxRate()) - getDiscountAmount();
    }
}

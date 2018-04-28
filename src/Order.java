import java.time.LocalDateTime;
import java.util.LinkedList;

public class Order {


    private class Receipt {
        private static final double TAX_RATE = 0.06;
        private double tipAmount;
        private double subtotal = 0;

        Receipt() {
            this.tipAmount = 0;
        }

        private double getTipAmount() {
            return tipAmount;
        }

        private double getSubtotal() {
            return subtotal; }

        private void addToSubtotal(double priceToAdd) {
            this.subtotal += priceToAdd;
        }

        public void setTipAmount(double tipAmount) {
            this.tipAmount = tipAmount;
        }
    }


    private LinkedList<ConsumableItem> items;
    private String customerName;
    private  LocalDateTime time;
    private Receipt receipt;
    private boolean tacoPriceBreakFlag = false;

    public Order( String customerName ){
        time = LocalDateTime.now();
        this.customerName = customerName;
        items = new LinkedList<>();
        receipt = new Receipt();
    }

    public void addItem(ConsumableItem item) {
        items.add(item);
        receipt.addToSubtotal(item.getUnitPrice());
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

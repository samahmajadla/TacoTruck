import java.util.LinkedList;

public class Order {

    private LinkedList<ConsumableItem> items;
    public Order(){
        items = new LinkedList<>();
    }


    public void addItem(ConsumableItem item) {
        items.add(item);
    }

    public int getOrderSize() {
        return items.size();
    }


    public ConsumableItem getItem(int index) {
        return items.get(index);
    }
}

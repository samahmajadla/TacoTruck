public abstract class Beverage extends ConsumableItem {

    private boolean isDiet = false;

    public Beverage(double price) {
        super(price);
    }

    public boolean isDiet() {
        return isDiet;
    }


}

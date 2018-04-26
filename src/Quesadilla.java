public class Quesadilla extends ConsumableItem{

    private boolean hasMeat = false;

    public Quesadilla() {
        super(5);
    }

    public boolean hasMeat() {
        return this.hasMeat;
    }

    public void addMeat() {
        this.hasMeat = true;
        this.setUnitPrice(this.getUnitPrice()+1);
    }


}

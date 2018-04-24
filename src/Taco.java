public class Taco extends ConsumableItem{
    private boolean hasGuacamole = false;

    public Taco() {
        super(3.0);
    }


    public boolean hasGuacamole() {
        return this.hasGuacamole;
    }

    public void addGuacamole() {
        this.hasGuacamole = true;
    }
}

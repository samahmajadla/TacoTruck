import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {

    private Order order;

    @Before
    public void setUp() {
      order = new Order();
    }

    @Test
    public void testOrderInventory() {
        Taco taco = new Taco();
        order.addItem(taco);
        assertEquals(1,order.getOrderSize());
    }

    @Test
    public void testAddMultipleItems() {
        Taco firstTaco = new Taco();
        Taco secondTaco = new Taco();

        order.addItem(firstTaco);
        order.addItem(secondTaco);

        assertEquals(2, order.getOrderSize());
    }

    @Test
    public void testOrderReturnsCorrectItem() {
        Taco firstTaco = new Taco();
        Taco secondTaco = new Taco();
        secondTaco.addGuacamole();
        Coke coke = new Coke();

        order.addItem(firstTaco);
        order.addItem(secondTaco);
        order.addItem(coke);

        assertEquals(firstTaco, order.getItem(0));
        assertEquals( secondTaco, order.getItem(1) );
        assertEquals( coke, order.getItem(2) );
    }

    @Test
    public void testOrderDefaults() {

        assertEquals(0, order.getOrderSize());

    }
}
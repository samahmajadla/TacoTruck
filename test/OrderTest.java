import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class OrderTest {

    private Order order;

    @Before
    public void setUp() {
      order = new Order("customer name");
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

    @Test
    public void testOrderHasName() {
        Order namedOrder = new Order("Sam");
        assertEquals("Sam", namedOrder.getCustomerName());
        assertEquals("customer name", order.getCustomerName());
    }

    @Test
    public void testOrderHasDateStamp(){
        LocalDateTime time = LocalDateTime.now();

        LocalDateTime orderTime = order.getOrderTime();
        assertEquals(time.getDayOfYear() , orderTime.getDayOfYear());
        assertEquals(time.getHour() , orderTime.getHour());
        assertEquals(time.getMinute() , orderTime.getMinute());
    }

    @Test
    public void testReceiptDefaults() {
        assertEquals(0.06, order.getTaxRate(),0);
        assertEquals(0.0, order.getTipAmount(),0);
        assertEquals(0.0, order.getSubtotal(), 0 );
    }

    @Test
    public void testAddedItemsAddToTotal(){
        order.addItem(new Quesadilla());
        assertEquals(5, order.getSubtotal(),0);
    }

    @Test
    public void testAdding3TacosGivesPriceBreak() {
        Taco taco = new Taco();
        order.addItem(taco);
        order.addItem(taco);
        order.addItem(taco);
        assertEquals(1.50, order.getDiscountAmount(), 0);
    }

    @Test
    public void testAdding2TacosGivesNoPriceBreak() {
        Taco taco = new Taco();
        order.addItem(taco);
        order.addItem(taco);
        order.addItem(new Coke());
        assertEquals(0, order.getDiscountAmount(), 0);
    }

    @Test
    public void testTotal_givenFourTacos_andADeliciousHorchata_hasDiscountAndTax(){
        double expectedTotal = (((4 * 3) + 2.5) * 1.06) - (4 * .5);

        Taco taco = new Taco();
        order.addItem(taco);
        order.addItem(taco);
        order.addItem(taco);
        order.addItem(taco);

        order.addItem(new Horchata());

        assertEquals(expectedTotal, order.getTotal(), 0);
    }

    @Test
    public void testTotal_givenTwoTacos_andACoke_hasNoDiscountYetTax() {
        double expectedTotal = ((2 *3) + 1.75) * 1.06;
        Taco taco = new Taco();

       order.addItem(taco);
       order.addItem(taco);
       order.addItem(new Coke());

       assertEquals(expectedTotal, order.getTotal(),0);
    }

    @Test
    public void testTipAmountCorrectlyAdded() {
        Taco taco = new Taco();
        Quesadilla quesadilla = new Quesadilla();

        order.addItem(taco);
        order.addItem(quesadilla);
    }

    @Test
    public void testTipSetter(){
        order.setTipAmount(2);
        assertEquals(2,order.getTipAmount(),0);
    }

}
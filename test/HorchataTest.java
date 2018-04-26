import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class HorchataTest {

    public static final double TEST_DELTA = 0.0001;

    private Horchata horchata;

    @Before
    public void setUp() {
        horchata = new Horchata();
    }

    @Test
    public void horchata_hasUnitPrice() {
        double expResult = 2.50;
        double result = horchata.getUnitPrice();
        assertEquals(expResult, result, TEST_DELTA);
    }

    @Test
    public void getIce_defaultsToShavedIce() {
        assertEquals(Ice.SHAVED, horchata.getIceChoice());
    }

    @Test
    public void getDiet_defaultsToNotDiet() {
        assertFalse(horchata.isDiet());
    }

    @Test
    public void canSetDietType(){
        horchata.setDiet(true);
        assertTrue(horchata.isDiet());
    }

    @Test
    public void canSetIceType() {
        horchata.setIceChoice(Ice.CUBED);
        assertEquals(Ice.CUBED, horchata.getIceChoice());
    }
}
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CokeTest {

    private Coke coke;

    @Before
    public void coke_setup(){
        coke = new Coke();
    }

    @Test
    public void coke_hasUnitPrice(){
        assertEquals(1.75, coke.getUnitPrice(), 0);
    }

    @Test
    public void getDiet_defaultsToNotDiet() {
        assertFalse(coke.isDiet());
    }

    @Test
    public void coke_canSetDiet() {
        coke.setDiet(true);

        assertTrue(coke.isDiet());
    }

    @Test
    public void coke_getIceDefaultsToCube() {
        assertEquals( Ice.CUBED, coke.getIceChoice() );
    }

    @Test
    public void coke_canSetIceType() {
        coke.setIceChoice(Ice.SHAVED);
        assertEquals( Ice.SHAVED, coke.getIceChoice() );
    }



}
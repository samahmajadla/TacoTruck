import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TacoTest {

    private Taco taco;

    @Before
    public void setUp(){
        taco = new Taco();
    }

    @Test
    public void taco_hasUnitPrice(){
        assertEquals(3,taco.getUnitPrice(),0);
    }

    @Test
    public void taco_createdWithoutGuac(){
        assertFalse(taco.hasGuacamole());
    }

    @Test
    public void taco_canAddGuac(){
        taco.addGuacamole();
        assertTrue(taco.hasGuacamole());
    }
}
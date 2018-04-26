import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuesadillaTest {

    private Quesadilla ques;

    @Before
    public void setUp() {

        ques = new Quesadilla();
    }

    @Test
    public void quesadilla_hasUnitPrice(){
        assertEquals(5.0, ques.getUnitPrice(), 0);
    }

    @Test
    public void ques_createdWithoutMeat(){
        assertFalse(ques.hasMeat());
    }

    @Test
    public void ques_canHaveMeatAdded(){
        ques.addMeat();
        assertEquals(6, ques.getUnitPrice(),0);
        assertTrue(ques.hasMeat());
    }


}
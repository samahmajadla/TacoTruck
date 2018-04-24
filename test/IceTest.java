import org.junit.Test;

import static org.junit.Assert.*;

public class IceTest {

    @Test
    public void ice_hasThreeTypes(){
        Ice[] iceTypes = Ice.values();
        assertEquals(4,iceTypes.length);
        assertEquals("NO_ICE", iceTypes[0].name());
        assertEquals("SHAVED", iceTypes[1].name());
        assertEquals("CRUSHED", iceTypes[2].name());
        assertEquals("CUBED", iceTypes[3].name());
    }

}
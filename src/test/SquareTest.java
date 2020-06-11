package test;

import zenGame.Square;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    Square s;
    @Before
    public void setUp() throws Exception {
        s = new Square(5,5);
    }

    @After
    public void tearDown() throws Exception {
        s = null;
    }

    @Test
    public void setBusy() {
        s.setBusy();
        assertEquals(s,false);
    }

    @Test
    public void isFree() {
        s.setBusy();
        assertEquals(s, false);
    }
}
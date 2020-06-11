package test;

import gameLauncher.GraphicType;
import gameLauncher.LaunchGame;
import zenGame.GameManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaunchGameTest {

    LaunchGame l;

    @Before
    public void setUp() throws Exception {
        l = new LaunchGame();
    }

    @After
    public void tearDown() throws Exception {
        l = null;
    }

    public void testLaunchGame(){
        assertNotNull(l);
    }

    @Test
    public void testAskGameType() {
        GraphicType g = GraphicType.Console;
        l.setGameType(g);
        assertEquals(l, GraphicType.Console);
    }
}
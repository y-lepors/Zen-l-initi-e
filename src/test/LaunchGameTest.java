package test;

import gameLauncher.LaunchGame;
import zenGame.GameManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * test the gameLauncher
 */
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
}
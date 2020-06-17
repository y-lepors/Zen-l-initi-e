package test;

import zenGame.GameManager;
import org.junit.After;
import org.junit.Before;
import zenGame.Mode;
import zenGame.Pawn;
import zenGame.Square;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameManagerTest {

    GameManager g;
    @Before
    public void setUp() throws Exception {
        g = new GameManager(new ArrayList<Pawn>(), "Yanis", "Enzo", null, null);
    }

    @After
    public void tearDown() throws Exception {
        g = null;
    }
}
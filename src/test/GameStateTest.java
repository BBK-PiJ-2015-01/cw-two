package test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import mastermind.GameState;
import mastermind.GameStateImpl;

public class GameStateTest {

	private GameState instance;
	@Before
	public void setUp() throws Exception {
		
		instance = new GameStateImpl();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

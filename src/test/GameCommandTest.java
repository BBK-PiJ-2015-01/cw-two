package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mastermind.GameCommand;

public class GameCommandTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void exitCommandTest() {
		
		String expectedToken = ":X";
		String resultToken = GameCommand.EXIT.getToken();
		assertEquals(expectedToken, resultToken);		
	}
	
	@Test
	public void newGameTest() {
		
		String expectedToken = ":N";
		String resultToken = GameCommand.NEW_GAME.getToken();
		assertEquals(expectedToken, resultToken);		
	}
	
	@Test
	public void restartGameTest() {
		
		String expectedToken = ":R";
		String resultToken = GameCommand.RESTART.getToken();
		assertEquals(expectedToken, resultToken);		
	}
}

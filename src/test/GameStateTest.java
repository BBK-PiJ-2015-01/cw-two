package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mastermind.GameState;
import mastermind.GameStateImpl;
import mastermind.GameStatus;

public class GameStateTest {

	private GameState instance;

	@Before
	public void setUp() throws Exception {

		instance = new GameStateImpl();
	}
	// ************************ Solution tests *******************************

	@Test
	public void getGameSolutionTest() {

		List<?> expectedGameSolution = null;
		List<?> resultGameSolution = instance.getSolution();
		assertEquals(expectedGameSolution, resultGameSolution);
	}
	
	@Test
	public void setGameSolutionTest() {
		
		List<String> expectedSolution = Arrays.asList(new String[] {"Any string value here"});
		instance.setSolution(expectedSolution);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setGameSolutionWithNullTest() {

		instance.setSolution(null);
	}
	
	@Test
	public void getGameSolutionAfterValidSetterTest() {

		List<String> expectedGameSolution = Arrays.asList(new String[] {"Any string value here"});
		instance.setSolution(expectedGameSolution);
		List<?> resultGameSolution = instance.getSolution();
		assertEquals(expectedGameSolution, resultGameSolution);;
	}
	
	// ************************ Message tests *******************************
	@Test
	public void getGameStatus() {

		GameStatus expectedGameStatus = null;
		GameStatus resultGameStatus = instance.getGameStatus();
		assertEquals(expectedGameStatus, resultGameStatus);
	}

	@Test
	public void setGameStatusWithValidValueTest() {

		instance.setGameStatus(GameStatus.IN_PLAY);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setGameStatusWithNullTest() {

		instance.setGameStatus(null);
	}

	// ************************ Message tests *******************************

	@Test
	public void getMessageNotSetTest() {

		String expectedMessage = null;
		String resultMessage = instance.getMessage();
		assertEquals(expectedMessage, resultMessage);
	}

	@Test
	public void getMessageAfterValidSetterTest() {

		String expectedMessage = "expectedMessage";
		instance.setMessage(expectedMessage);
		String resultMessage = instance.getMessage();
		assertEquals(expectedMessage, resultMessage);
	}

}

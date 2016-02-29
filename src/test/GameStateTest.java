package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mastermind.GameAttempt;
import mastermind.GameAttemptImpl;
import mastermind.GameState;
import mastermind.GameStateImpl;
import mastermind.GameStatus;

public class GameStateTest {

	private GameState instance;

	@Before
	public void setUp() throws Exception {

		instance = new GameStateImpl();
	}

	// ************************ History tests *******************************
	@Test
	public void getGameHistoryNotSetTest() {

		List<GameAttempt> resultGameHistory = instance.getGameHistory();
		assertNotNull(resultGameHistory);
		assertTrue(resultGameHistory.isEmpty());
	}

	@Test
	public void addGameHistoryValidTest() {

		instance.addAttempt(new GameAttemptImpl());
	}

	@Test(expected = IllegalArgumentException.class)
	public void addGameHistoryNullValueTest() {

		instance.addAttempt(null);
	}

	@Test
	public void addGameHistoryCheckContentsTest() {

		GameAttempt expectedGameAttempt = new GameAttemptImpl();
		instance.addAttempt(expectedGameAttempt);
		List<GameAttempt> resultGameHistory = instance.getGameHistory();

		int expectedHistorySize = 1;
		int resultHistorySize = resultGameHistory.size();

		assertEquals(expectedHistorySize, resultHistorySize);
		assertTrue(resultGameHistory.contains(expectedGameAttempt));

		instance.addAttempt(expectedGameAttempt);
		resultGameHistory = instance.getGameHistory();

		expectedHistorySize = 2;
		resultHistorySize = resultGameHistory.size();
		assertEquals(expectedHistorySize, resultHistorySize);

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

		List<String> expectedSolution = Arrays.asList(new String[] { "Any string value here" });
		instance.setSolution(expectedSolution);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setGameSolutionWithNullTest() {

		instance.setSolution(null);
	}

	@Test
	public void getGameSolutionAfterValidSetterTest() {

		List<String> expectedGameSolution = Arrays.asList(new String[] { "Any string value here" });
		instance.setSolution(expectedGameSolution);
		List<?> resultGameSolution = instance.getSolution();
		assertEquals(expectedGameSolution, resultGameSolution);
		;
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

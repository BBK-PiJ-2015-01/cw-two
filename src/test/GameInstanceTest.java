package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import mastermind.GameAttempt;
import mastermind.GameAttemptImpl;
import mastermind.GameDetails;
import mastermind.GameDetailsImpl;
import mastermind.GameInstance;
import mastermind.GameInstanceImpl;
import mastermind.GameState;
import mastermind.GameStatus;

public class GameInstanceTest {

	private GameInstance instance;

	@Before
	public void setUp() throws Exception {
	}

	// ***********************************************************************************
	// Constructor tests
	// ***********************************************************************************
	@Test
	public void constructWithGameDetailsTest() {

		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);
	}

	// ***********************************************************************************
	// Remaining attempts guesses
	// ***********************************************************************************

	@Test
	public void noAttemptsMadeTest() {
		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);

		Long resultRemainingAttempts = instance.getRemainingAttempts();
		assertEquals(expectedAttempts, resultRemainingAttempts);
	}

	@Test
	public void oneAttemptMadeTest() {
		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);

		instance.evaluateAttempt(new GameAttemptImpl());

		Long expectedRemainingAttempts = 11L;
		Long resultRemainingAttempts = instance.getRemainingAttempts();
		assertEquals(expectedRemainingAttempts, resultRemainingAttempts);
	}

	// ***********************************************************************************
	// Game details test
	// ***********************************************************************************
	@Test
	public void gameDetailsTest() {

		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);

		GameDetails resultGameDetails = instance.getGameDetails();
		assertEquals(expectedGameDetails, resultGameDetails);
	}

	// ***********************************************************************************
	// Game state test
	// ***********************************************************************************
	@Test
	public void gameStateTest() {

		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);

		GameState resultGameState = instance.getGameState();
		assertNotNull(resultGameState);
	}

	@Test
	public void gameStateSolutionNotNullTest() {

		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);

		GameState resultGameState = instance.getGameState();
		assertNotNull(resultGameState.getSolution());
	}

	@Test
	public void gameStateSolutionNotEmptyTest() {

		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);

		GameState resultGameState = instance.getGameState();
		int expectedSolutionSize = 4;
		int resultSolutionSize = resultGameState.getSolution().size();
		assertEquals(expectedSolutionSize, resultSolutionSize);
	}

	@Test
	public void gameStateStatusTest() {

		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);

		GameState resultGameState = instance.getGameState();
		GameStatus expectedGameStatus = GameStatus.IN_PLAY;
		GameStatus resultGameStatus = resultGameState.getGameStatus();
		assertEquals(expectedGameStatus, resultGameStatus);
	}

	@Test
	public void gameStateAttemptAfterOneAttemptHistoryTest() {

		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);

		instance.evaluateAttempt(new GameAttemptImpl());

		GameState resultGameState = instance.getGameState();
		List<GameAttempt> expectedGameHistory = resultGameState.getGameHistory();
		int expectedGameHistorySize = 1;
		int resultGameHistorySize = expectedGameHistory.size();

		assertEquals(expectedGameHistorySize, resultGameHistorySize);
	}

	// ***********************************************************************************
	// Game play tests
	// ***********************************************************************************
	@Test(expected = NullPointerException.class)
	public void evaluateNullAttemptTest() {

		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);
		instance.evaluateAttempt(null);
	}
	
	@Test
	public void evaluateCorrectGuessTest() {

		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);

		GameState resultGameState = instance.getGameState();

		GameAttempt correctGuess = new GameAttemptImpl();
		correctGuess.setAttempt(resultGameState.getSolution());

		instance.evaluateAttempt(correctGuess);
		resultGameState = instance.getGameState();

		GameStatus expectedGameStatus = GameStatus.SOLVED;
		GameStatus resultGameStatus = resultGameState.getGameStatus();
		assertEquals(expectedGameStatus, resultGameStatus);
		
		
		// Ignore any further attempts after solutiuon
		instance.evaluateAttempt(correctGuess);
		resultGameState = instance.getGameState();
		int expectedGameHistorySize = 1;
		int resultGameHistorySize = resultGameState.getGameHistory().size();
		assertEquals(expectedGameHistorySize, resultGameHistorySize);	
	}
	
	@Test
	public void evaluateCorrectGuessGameHistoryTest() {

		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);

		GameState resultGameState = instance.getGameState();

		GameAttempt correctGuess = new GameAttemptImpl();
		correctGuess.setAttempt(resultGameState.getSolution());

		instance.evaluateAttempt(correctGuess);
		resultGameState = instance.getGameState();

		int expectedGameHistorySize = 1;
		int resultGameHistorySize = resultGameState.getGameHistory().size();
		assertEquals(expectedGameHistorySize, resultGameHistorySize);	
		
		//
		GameAttempt gameHistoryAttempt = resultGameState.getGameHistory().get(0);
		Long expectedExactScore = 4L;
		Long expectedNearScore = 0L;
		
		Long resultExactScore = gameHistoryAttempt.getAttemptResult().getExactScore();
		Long resultNearScore = gameHistoryAttempt.getAttemptResult().getNearScore();
		
		assertEquals(expectedExactScore, resultExactScore);
		assertEquals(expectedNearScore, resultNearScore);
	}
	
	@Test
	public void evaluateInCorrectGuessTest() {

		Long expectedAttempts = 12L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);

		GameState resultGameState = instance.getGameState();

		List<?> incorrectGuess = new LinkedList(resultGameState.getSolution());
		incorrectGuess.remove(incorrectGuess.size()-1);
		GameAttempt incorrectAttempt = new GameAttemptImpl();
		incorrectAttempt.setAttempt(incorrectGuess);

		instance.evaluateAttempt(incorrectAttempt);
		resultGameState = instance.getGameState();

		GameStatus expectedGameStatus = GameStatus.IN_PLAY;
		GameStatus resultGameStatus = resultGameState.getGameStatus();
		assertEquals(expectedGameStatus, resultGameStatus);
	}
	
	@Test
	public void evaluateGameExpiredGuessTest() {

		Long expectedAttempts = 1L;
		Long expectedPermutations = 4L;
		GameDetails expectedGameDetails = new GameDetailsImpl(expectedAttempts, expectedPermutations,
				getSixColourCharacterMap());
		instance = new GameInstanceImpl(expectedGameDetails);

		GameState resultGameState = instance.getGameState();

		List<?> incorrectGuess = new LinkedList(resultGameState.getSolution());
		incorrectGuess.remove(incorrectGuess.size()-1);
		GameAttempt incorrectAttempt = new GameAttemptImpl();
		incorrectAttempt.setAttempt(incorrectGuess);

		instance.evaluateAttempt(incorrectAttempt);
		resultGameState = instance.getGameState();

		GameStatus expectedGameStatus = GameStatus.EXPIRED;
		GameStatus resultGameStatus = resultGameState.getGameStatus();
		assertEquals(expectedGameStatus, resultGameStatus);
		
		// Ignore any further attempts after expiration
		instance.evaluateAttempt(incorrectAttempt);
		resultGameState = instance.getGameState();
		int expectedGameHistorySize = 1;
		int resultGameHistorySize = resultGameState.getGameHistory().size();
		assertEquals(expectedGameHistorySize, resultGameHistorySize);		
	}
	


	// ***********************************************************************************
	// Private methods here...
	// ***********************************************************************************
	private Map<Character, String> getSixColourCharacterMap() {

		Map<Character, String> returnMap = new HashMap<>();
		returnMap.put('B', "blue");
		returnMap.put('G', "green");
		returnMap.put('O', "orange");
		returnMap.put('P', "purple");
		returnMap.put('R', "red");
		returnMap.put('Y', "yellow");
		return returnMap;
	}
}

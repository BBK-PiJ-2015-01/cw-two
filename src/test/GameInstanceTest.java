package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import mastermind.GameAttemptImpl;
import mastermind.GameDetails;
import mastermind.GameDetailsImpl;
import mastermind.GameInstance;
import mastermind.GameInstanceImpl;
import mastermind.GameState;

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

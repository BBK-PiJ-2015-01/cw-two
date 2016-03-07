package test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import mastermind.GameDetails;
import mastermind.GameDetailsImpl;

public class GameDetailsTest {

	private GameDetails instance;

	@Before
	public void setUp() throws Exception {

		instance = new GameDetailsImpl();
	}
	
	// ************************ Constructor tests *******************************
	@Test
	public void constructorTest() {

		Long expectedNumOfAttempts = 12L;
		Long expectedNumOfPermutations = 4L;
		instance = new GameDetailsImpl(expectedNumOfAttempts, expectedNumOfPermutations, getSixColourCharacterMap());
		
		
		Long resultNumOfAttempts = instance.getNumberOfAttempts();
		Long resultNumOfPermutations = instance.getNumberOfPermutations();

		assertEquals(expectedNumOfAttempts, resultNumOfAttempts);
		assertEquals(expectedNumOfPermutations, resultNumOfPermutations);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalAttemptsConstructorTest() {

		Long expectedNumOfAttempts = -1L;
		Long expectedNumOfPermutations = 4L;
		instance = new GameDetailsImpl(expectedNumOfAttempts, expectedNumOfPermutations, getSixColourCharacterMap());		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalPermutationsConstructorTest() {

		Long expectedNumOfAttempts = 12L;
		Long expectedNumOfPermutations = -1L;
		instance = new GameDetailsImpl(expectedNumOfAttempts, expectedNumOfPermutations, getSixColourCharacterMap());		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalGameMapConstructorTest() {

		Long expectedNumOfAttempts = 12L;
		Long expectedNumOfPermutations = 4L;
		instance = new GameDetailsImpl(expectedNumOfAttempts, expectedNumOfPermutations, null);		
	}

	// ************************ Attempt# tests *******************************

	@Test
	public void getNumOfAttemptsNotSetTest() {

		Long expectedNumOfAttempts = null;
		Long resultNumOfAttempts = instance.getNumberOfAttempts();

		assertEquals(expectedNumOfAttempts, resultNumOfAttempts);
	}

	@Test
	public void setNumOfAttemptsValidValueTest() {

		instance.setNumberOfAttempts(1L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setNumOfAttemptsNullTest() {

		instance.setNumberOfAttempts(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setNumOfAttemptsToNegativeNumberTest() {

		instance.setNumberOfAttempts(-1L);
	}
	
	@Test
	public void getNumOfAttemptsAfterValidSetterTest() {


		Long expectedNumOfAttempts = 12L;
		instance.setNumberOfAttempts(expectedNumOfAttempts);
		
		Long resultNumOfAttempts = instance.getNumberOfAttempts();
		assertEquals(expectedNumOfAttempts, resultNumOfAttempts);
	}

	// ************************ Permutations# tests *******************************
	
	@Test
	public void getNumOfPermutationsNotSetTest() {

		Long expectedNumOfPermutations = null;
		Long resultNumOfPermutations = instance.getNumberOfPermutations();

		assertEquals(expectedNumOfPermutations, resultNumOfPermutations);
	}
	
	@Test
	public void setNumOfPermutationsValidValueTest() {

		instance.setNumberOfPermutations(1L);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setNumOfPermutationsNullTest() {

		instance.setNumberOfPermutations(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setNumOfPermutationsToNegativeNumberTest() {

		instance.setNumberOfPermutations(-1L);
	}
	
	@Test
	public void getNumOfPermutationssAfterValidSetterTest() {


		Long expectedNumOfPermutations = 4L;
		instance.setNumberOfAttempts(expectedNumOfPermutations);
		
		Long resultNumOfPermutations = instance.getNumberOfAttempts();
		assertEquals(expectedNumOfPermutations, resultNumOfPermutations);
	}
	
	// ************************ Pegs# tests *******************************

	@Test
	public void getGameChoicesNotSetTest() {

		Map<?,?> expectedGameChoices = null;
		Map<?,?> resultGameChoices = instance.getGameChoices();

		assertEquals(expectedGameChoices, resultGameChoices);
	}
	
	@Test
	public void setGameChoicesValidTest() {
		
		Map<Character,String> expectedGameChoices = new HashMap<>();
		expectedGameChoices.put('G', "Green");

		instance.setGameChoices(expectedGameChoices);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setGameChoicesNullTest() {

		instance.setGameChoices(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setGameChoicesEmptyMapTest() {

		instance.setGameChoices(Collections.EMPTY_MAP);
	}
	
	@Test
	public void getGameChoicesAfterValidSetterTest() {


		Map<Character,String> expectedGameChoices = new HashMap<>();
		expectedGameChoices.put('G', "Green");

		instance.setGameChoices(expectedGameChoices);
		
		Map<?,?> resultGameChoices = instance.getGameChoices();
		assertEquals(expectedGameChoices, resultGameChoices);
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

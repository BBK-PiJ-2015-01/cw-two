package test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		instance = new GameDetailsImpl(expectedNumOfAttempts, expectedNumOfPermutations, getTestGameValues());
		
		
		Long resultNumOfAttempts = instance.getNumberOfAttempts();
		Long resultNumOfPermutations = instance.getNumberOfPermutations();

		assertEquals(expectedNumOfAttempts, resultNumOfAttempts);
		assertEquals(expectedNumOfPermutations, resultNumOfPermutations);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalAttemptsConstructorTest() {

		Long expectedNumOfAttempts = -1L;
		Long expectedNumOfPermutations = 4L;
		instance = new GameDetailsImpl(expectedNumOfAttempts, expectedNumOfPermutations, getTestGameValues());		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void illegalPermutationsConstructorTest() {

		Long expectedNumOfAttempts = 12L;
		Long expectedNumOfPermutations = -1L;
		instance = new GameDetailsImpl(expectedNumOfAttempts, expectedNumOfPermutations, getTestGameValues());		
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

		Set<?> expectedGameChoices = null;
		Set<?> resultGameChoices = instance.getGameChoices();

		assertEquals(expectedGameChoices, resultGameChoices);
	}
	
	@Test
	public void setGameChoicesValidTest() {
		
		Set<Character> expectedGameChoices = new HashSet<>();
		expectedGameChoices.add('G');

		instance.setGameChoices(expectedGameChoices);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setGameChoicesNullTest() {

		instance.setGameChoices(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setGameChoicesEmptyMapTest() {

		instance.setGameChoices(Collections.EMPTY_SET);
	}
	
	@Test
	public void getGameChoicesAfterValidSetterTest() {


		Set<Character> expectedGameChoices = new HashSet<>();
		expectedGameChoices.add('G');

		instance.setGameChoices(expectedGameChoices);
		
		Set<?> resultGameChoices = instance.getGameChoices();
		assertEquals(expectedGameChoices, resultGameChoices);
	}
	
    private Set<Character> getTestGameValues() {
   	 
        Set<Character> returnMap = new HashSet<>();
        returnMap.add('B');
        returnMap.add('G');
        returnMap.add('O');
        returnMap.add('P');
        returnMap.add('R');
        returnMap.add('Y');
        return returnMap;
    }
}

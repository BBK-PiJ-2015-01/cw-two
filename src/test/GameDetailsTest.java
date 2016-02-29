package test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
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
	public void setNumOfAttemptsTONegativeNumberTest() {

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

		instance.setGameChoices(Collections.EMPTY_MAP);
	}
	
}
